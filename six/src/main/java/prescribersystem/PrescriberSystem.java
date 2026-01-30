package prescribersystem;

import java.util.List;

import prescribersystem.core.Demand;
import prescribersystem.core.Patient;
import prescribersystem.core.PatientDatabase;
import prescribersystem.core.Prescriber;
import prescribersystem.observers.ExportCaseObserver;
import prescribersystem.observers.NotifyClientObserver;
import prescribersystem.observers.StoreCaseObserver;

public class PrescriberSystem {

	Prescriber prescriber;
	PatientDatabase patientDatabase;

	public record DemandParts(
			String patientId,
			List<SymptomEnum> symptoms) {
	}

	public PrescriberSystem(String diseases) {
		this.patientDatabase = new PatientDatabase();
		this.prescriber = new Prescriber(patientDatabase, diseases);
		prescriber.start();

		prescriber.registerDoneObserver(new NotifyClientObserver());
		prescriber.registerDoneObserver(new StoreCaseObserver());
		prescriber.registerDoneObserver(new ExportCaseObserver());
	}

	public void importPatients(String patients) {
		this.patientDatabase.importPatients(patients);
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
