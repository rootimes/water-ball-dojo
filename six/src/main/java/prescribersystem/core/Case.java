package prescribersystem.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        return List.copyOf(symptoms);
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
}
