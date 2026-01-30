package prescribersystem.observers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import prescribersystem.core.Case;
import prescribersystem.core.PatientDatabase;
import prescribersystem.core.Prescription;
import prescribersystem.core.interfaces.DoneObserver;

public class ExportCaseObserver implements DoneObserver {

    private static final ObjectMapper MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .enable(SerializationFeature.INDENT_OUTPUT);

    @Override
    public void handle(PrintStream client, PatientDatabase patientDatabase, Case caseData, String path) {
        String fileType = parseFileType(path);

        switch (fileType) {
            case "json":
                exportAsJson(caseData, path);
                break;
            case "csv":
                exportAsCsv(caseData, path);
                break;
            default:
                throw new IllegalArgumentException("Unsupported file type: " + fileType);
        }

        if (client != null)
            client.println("Exported case to: " + path);
    }

    private String parseFileType(String path) {
        if (path == null || path.isBlank())
            throw new IllegalArgumentException("Path is empty");

        int dot = path.lastIndexOf('.');
        int slash = Math.max(path.lastIndexOf('/'), path.lastIndexOf('\\'));
        if (dot <= slash || dot == path.length() - 1) {
            throw new IllegalArgumentException("Path has no valid extension: " + path);
        }
        return path.substring(dot + 1).toLowerCase();
    }

    private void exportAsJson(Case caseData, String path) {
        ensureParentDirExists(path);
        try {
            MAPPER.writeValue(new File(path), caseData);
        } catch (Exception e) {
            throw new RuntimeException("Failed to export json to " + path, e);
        }
    }

    private void exportAsCsv(Case caseData, String path) {
        ensureParentDirExists(path);

        String header = String.join(",",
                "patientId",
                "caseTime",
                "symptoms",
                "name",
                "potentialDisease",
                "medications",
                "usage");

        Prescription p = caseData.getPrescription();

        String patientId = safe(caseData.getPatientId());
        String caseTime = caseData.getCaseTime() == null ? "" : caseData.getCaseTime().toString();
        String symptoms = join(caseData.getSymptoms(), ";"); // symptoms 用 ; 串起來
        String prescriptionName = p == null ? "" : safe(p.getName());
        String potentialDisease = p == null ? "" : safe(p.getPotentialDisease());
        String medications = (p == null) ? "" : join(p.getMedications(), ";"); // meds 用 ; 串起來
        String usage = p == null ? "" : safe(p.getUsage());

        String row = String.join(",",
                csv(patientId),
                csv(caseTime),
                csv(symptoms),
                csv(prescriptionName),
                csv(potentialDisease),
                csv(medications),
                csv(usage));

        try (BufferedWriter w = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8))) {

            w.write(header);
            w.newLine();
            w.write(row);
            w.newLine();

        } catch (Exception e) {
            throw new RuntimeException("Failed to export csv to " + path, e);
        }
    }

    private void ensureParentDirExists(String path) {
        File parent = new File(path).getParentFile();
        if (parent != null && !parent.exists()) {
            boolean ok = parent.mkdirs();
            if (!ok)
                throw new RuntimeException("Failed to create dir: " + parent.getAbsolutePath());
        }
    }

    private String safe(String v) {
        return v == null ? "" : v;
    }

    private String join(List<?> list, String delimiter) {
        if (list == null || list.isEmpty())
            return "";
        return list.stream().map(Object::toString).collect(Collectors.joining(delimiter));
    }

    private String csv(String v) {
        if (v == null)
            return "";
        boolean needQuote = v.contains(",") || v.contains("\"") || v.contains("\n") || v.contains("\r");
        String escaped = v.replace("\"", "\"\"");
        return needQuote ? "\"" + escaped + "\"" : escaped;
    }
}