package prescribersystem.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PatientDatabase {
    private Map<String, Patient> patients = new HashMap<>();

    public Optional<Patient> getPatientById(String patientId) {
        return Optional.ofNullable(patients.get(patientId));
    }
}
