package prescribersystem.core;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import prescribersystem.SymptomEnum;

public class Demand {

    private String patientId;
    private int age;
    private char gender;
    private float height;
    private float weight;
    private List<SymptomEnum> symptoms;
    private String path;
    private PrintStream client;

    public Demand(PrintStream client, String patientId, int age,
            char gender, float height, float weight,
            String symptoms, String path) {
        this.patientId = patientId;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.path = path;
        this.client = client;
        this.symptoms = parseSymptoms(symptoms);
    }

    public String getPatientId() {
        return patientId;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public List<SymptomEnum> getSymptoms() {
        return symptoms;
    }

    public String getPath() {
        return path;
    }

    public PrintStream getClient() {
        return client;
    }

    private List<SymptomEnum> parseSymptoms(String symptoms) {
        if (symptoms == null || symptoms.isBlank()) {
            throw new IllegalArgumentException("Demand data is empty");
        }

        List<SymptomEnum> symptomsList = new ArrayList<>();
        for (String symptomStr : symptoms.split(",")) {
            SymptomEnum symptom = SymptomEnum.fromString(symptomStr.trim());
            symptomsList.add(symptom);
        }
        return symptomsList;
    }
}
