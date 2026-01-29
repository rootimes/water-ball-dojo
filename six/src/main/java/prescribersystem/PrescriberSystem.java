package prescribersystem;

import prescribersystem.core.PatientDatabase;
import prescribersystem.core.Prescriber;

import java.util.List;

import prescribersystem.core.Demand;
import prescribersystem.core.Patient;

public class PrescriberSystem {

	Prescriber prescriber;
	PatientDatabase patientDatabase;

	public record DemandParts(
			String patientId,
			List<SymptomEnum> symptoms) {
	}

	public PrescriberSystem(String diseases) {
		prescriber = new Prescriber(diseases);
	}

	public void updatePatients(String patients) {
	}

	public void prescribe(String patientId, String symptoms, String path) {

		Patient patient = patientDatabase.getPatientById(patientId)
				.orElseThrow(() -> new IllegalArgumentException("Patient not found: " + patientId));

		int age = patient.getAge();
		float height = patient.getHeight();
		float weight = patient.getWeight();

		Demand demand = new Demand(System.out, patientId, age, height, weight, symptoms, path);

		prescriber.submit(demand);
	}
}
