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
}
