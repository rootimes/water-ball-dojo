package prescribersystem;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import prescribersystem.core.Case;
import prescribersystem.core.Demand;
import prescribersystem.core.Patient;
import prescribersystem.core.PatientDatabase;
import prescribersystem.core.Prescriber;
import prescribersystem.core.Prescription;
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
			"COVID-19", () -> new Covid19Rule(null),
			"Attractive", () -> new AttractiveRule(null),
			"SleepApneaSyndrome", () -> new SleepApneaSyndromeRule(null));

	public record DemandParts(
			String patientId,
			List<SymptomEnum> symptoms) {
	}

	public PrescriberSystem(String diseases) {
		PrescribeHandler handler = prescribeHandler(diseases);
		this.patientDatabase = new PatientDatabase();
		this.prescriber = new Prescriber(patientDatabase, handler);

		prescriber.start();
		prescriber.registerDoneObserver(new NotifyClientObserver());
		prescriber.registerDoneObserver(new StoreCaseObserver());
		prescriber.registerDoneObserver(new ExportCaseObserver());
	}

	public void importPatients(String patients) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode rootNode = mapper.readTree(patients);
			if (rootNode.isArray()) {
				for (JsonNode patientNode : rootNode) {
					Patient patient = parsePatient(patientNode);
					patientDatabase.addPatient(patient);
				}
			}
		} catch (IOException e) {
			throw new IllegalArgumentException("Invalid patient JSON", e);
		}
	}

	public void prescribe(String patientId, String symptoms, String path) {

		Demand demand = new Demand(System.out, patientId, symptoms, path);

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

	private Patient parsePatient(JsonNode patientJson) {
		String id = patientJson.get("id").asText();
		String name = patientJson.get("name").asText();
		char gender = patientJson.get("gender").asText().charAt(0);
		int age = patientJson.get("age").asInt();
		float height = (float) patientJson.get("height").asDouble();
		float weight = (float) patientJson.get("weight").asDouble();
		List<Case> cases = new ArrayList<>();
		for (JsonNode caseNode : patientJson.get("cases")) {
			cases.add(parseCase(caseNode));
		}

		return new Patient(id, name, gender, age, height, weight, cases);
	}

	private Case parseCase(JsonNode caseJson) {
		String patientId = caseJson.get("patientId").asText();
		List<SymptomEnum> symptoms = new ArrayList<>();
		if (caseJson.has("symptoms")) {
			for (JsonNode symptomNode : caseJson.get("symptoms")) {
				String symptomStr = symptomNode.asText();
				symptoms.add(SymptomEnum.valueOf(symptomStr));
			}
		}
		Prescription prescription = parsePrescription(caseJson.get("prescription"));
		LocalDate caseTime = LocalDate.parse(caseJson.get("caseTime").asText());
		return new Case(patientId, symptoms, prescription, caseTime);
	}

	private Prescription parsePrescription(JsonNode prescriptionJson) {
		String name = prescriptionJson.get("name").asText();
		String potentialDisease = prescriptionJson.get("potentialDisease").asText();
		List<String> medications = new java.util.ArrayList<>();
		JsonNode medicinesNode = prescriptionJson.get("medicines");
		if (medicinesNode != null) {
			for (JsonNode medNode : medicinesNode) {
				medications.add(medNode.asText());
			}
		}
		String usage = prescriptionJson.get("usage").asText();
		return new Prescription(name, potentialDisease, medications, usage);
	}
}
