package prescribersystem.core;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PatientDatabase {
    private Map<String, Patient> patients = new HashMap<>();

    public void importPatients(String patientsJson) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(patientsJson);
            if (rootNode.isArray()) {
                for (JsonNode patientNode : rootNode) {
                    Patient patient = new Patient(patientNode);
                    patients.put(patient.getId(), patient);
                }
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid patient JSON", e);
        }
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