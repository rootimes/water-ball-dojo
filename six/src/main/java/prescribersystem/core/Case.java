package prescribersystem.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import prescribersystem.SymptomEnum;

public class Case {
    private String patientId;

    private final List<SymptomEnum> symptoms = new ArrayList<>();

    private final Prescription prescription;

    private final LocalDate caseTime;

    public Case(String patientId, List<SymptomEnum> symptoms, Prescription prescription, LocalDate caseTime) {
        this.patientId = patientId;
        this.symptoms.addAll(symptoms);
        this.prescription = prescription;
        this.caseTime = caseTime;
    }

    public List<SymptomEnum> getSymptoms() {
        return symptoms;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public LocalDate getCaseTime() {
        return caseTime;
    }

    public String getPatientId() {
        return patientId;
    }

    public static Case parse(JsonNode json) {
        String patientId = json.get("patientId").asText();
        List<SymptomEnum> symptoms = new ArrayList<>();
        if (json.has("symptoms")) {
            for (JsonNode symptomNode : json.get("symptoms")) {
                String symptomStr = symptomNode.asText();
                symptoms.add(SymptomEnum.valueOf(symptomStr));
            }
        }
        Prescription prescription = Prescription.parse(json.get("prescription"));
        LocalDate caseTime = LocalDate.parse(json.get("caseTime").asText());
        return new Case(patientId, symptoms, prescription, caseTime);
    }
}
