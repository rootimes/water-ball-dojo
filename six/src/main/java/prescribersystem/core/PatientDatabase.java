package prescribersystem.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class PatientDatabase {
    private Map<String, Patient> patients = new HashMap<>();

    public void addPatient(Patient patient) {
        patients.put(patient.getId(), patient);
    }

    public Optional<Patient> getPatientById(String patientId) {
        return Optional.ofNullable(patients.get(patientId));
    }

    public String getPatientName(String patientId) {
        Patient patient = patients.get(patientId);
        if (patient != null) {
            return patient.getName();
        } else {
            throw new IllegalArgumentException("Patient not found: " + patientId);
        }
    }

    public int getPatientAge(String patientId) {
        Patient patient = patients.get(patientId);
        if (patient != null) {
            return patient.getAge();
        } else {
            throw new IllegalArgumentException("Patient not found: " + patientId);
        }
    }

    public char getPatientGender(String patientId) {
        Patient patient = patients.get(patientId);
        if (patient != null) {
            return patient.getGender();
        } else {
            throw new IllegalArgumentException("Patient not found: " + patientId);
        }
    }

    public float getPatientHeight(String patientId) {
        Patient patient = patients.get(patientId);
        if (patient != null) {
            return patient.getHeight();
        } else {
            throw new IllegalArgumentException("Patient not found: " + patientId);
        }
    }

    public float getPatientWeight(String patientId) {
        Patient patient = patients.get(patientId);
        if (patient != null) {
            return patient.getWeight();
        } else {
            throw new IllegalArgumentException("Patient not found: " + patientId);
        }
    }

    public void storeCase(Case caseData) {
        Patient patient = patients.get(caseData.getPatientId());
        if (patient != null) {
            patient.addCase(caseData);
        } else {
            throw new IllegalArgumentException("Patient not found: " + caseData.getPatientId());
        }
    }
}