package prescribersystem.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

import prescribersystem.SymptomEnum;


public class Case {
    private final List<SymptomEnum> symptoms = new ArrayList<>();

    private final Prescription prescription;

    private final LocalDate caseTime;

    public Case(List<SymptomEnum> symptoms, Prescription prescription, LocalDate caseTime) {
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

    public static Case parse(JsonNode json) {
        List<SymptomEnum> symptoms = new ArrayList<>();
        if (json.has("symptoms")) {
            for (JsonNode symptomNode : json.get("symptoms")) {
                String symptomStr = symptomNode.asText();
                symptoms.add(SymptomEnum.valueOf(symptomStr));
            }
        }
        Prescription prescription = Prescription.parse(json.get("prescription"));
        LocalDate caseTime = LocalDate.parse(json.get("caseTime").asText());
        return new Case(symptoms, prescription, caseTime);
    }
}
