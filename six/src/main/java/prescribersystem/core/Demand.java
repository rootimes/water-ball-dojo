package prescribersystem.core;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import prescribersystem.SymptomEnum;

public class Demand {

    private String patientId;
    private List<SymptomEnum> symptoms;
    private String path;
    private PrintStream client;

    public Demand(PrintStream client, String patientId,
            String symptoms, String path) {
        this.patientId = patientId;
        this.path = path;
        this.client = client;
        this.symptoms = parseSymptoms(symptoms);
    }

    public String getPatientId() {
        return patientId;
    }

    public List<SymptomEnum> getSymptoms() {
        return symptoms;
    }

    public String getPath() {
        return path;
    }

    public PrintStream getClient() {
        return client;
    }

    private List<SymptomEnum> parseSymptoms(String symptoms) {
        if (symptoms == null || symptoms.isBlank()) {
            throw new IllegalArgumentException("Demand data is empty");
        }

        List<SymptomEnum> symptomsList = new ArrayList<>();
        for (String symptomStr : symptoms.split(",")) {
            SymptomEnum symptom = SymptomEnum.fromString(symptomStr.trim());
            symptomsList.add(symptom);
        }
        return symptomsList;
    }
}
