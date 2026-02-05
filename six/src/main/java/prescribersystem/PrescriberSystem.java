package prescribersystem;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import prescribersystem.core.Demand;
import prescribersystem.core.Patient;
import prescribersystem.core.PatientDatabase;
import prescribersystem.core.Prescriber;
import prescribersystem.core.interfaces.PrescribeHandler;
import prescribersystem.observers.ExportCaseObserver;
import prescribersystem.observers.NotifyClientObserver;
import prescribersystem.observers.StoreCaseObserver;
import prescribersystem.rules.AttractiveRule;
import prescribersystem.rules.Covid19Rule;
import prescribersystem.rules.SleepApneaSyndromeRule;

public class PrescriberSystem {

	private Prescriber prescriber;
	private PatientDatabase patientDatabase;

	private Map<String, Supplier<PrescribeHandler>> diseaseSupplier = Map.of(
			"covid19", () -> new Covid19Rule(null),
			"attractive", () -> new AttractiveRule(null),
			"sleep_apnea_syndrome", () -> new SleepApneaSyndromeRule(null));

	public record DemandParts(
			String patientId,
			List<SymptomEnum> symptoms) {
	}

	public PrescriberSystem(String diseases) {
		PrescribeHandler handler = prescribeHandler(diseases);
		this.prescriber = new Prescriber(patientDatabase, handler);
		this.patientDatabase = new PatientDatabase();

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
		char gender = patient.getGender();

		Demand demand = new Demand(System.out, patientId, age, gender, height, weight, symptoms, path);

		prescriber.submit(demand);
	}

	private PrescribeHandler prescribeHandler(String diseases) {
		List<String> keys = Arrays.stream(diseases.split(","))
				.map(String::trim).filter(s -> !s.isBlank())
				.toList();

		PrescribeHandler handler = null;
		PrescribeHandler nextHandler = null;

		for (String key : keys) {
			Supplier<PrescribeHandler> supplierHandler = diseaseSupplier.get(key);
			if (supplierHandler == null) {
				throw new IllegalArgumentException("Unknown disease: " + key);
			}

			PrescribeHandler currentHandler = supplierHandler.get();
			if (handler != null) {
				nextHandler.setNext(currentHandler);
				nextHandler = currentHandler;
				continue;
			}

			handler = currentHandler;
			nextHandler = currentHandler; // 第一次 nexHandler 與初始 handler 一樣
		}

		return handler;
	}
}
