package prescribersystem.core;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public class Prescription {
    private final String name;
    private final String potentialDisease;
    private final List<String> medications;
    private final String usage;

    public Prescription(String name, String potentialDisease, List<String> medications, String usage) {
        this.name = name;
        this.potentialDisease = potentialDisease;
        this.medications = medications;
        this.usage = usage;
    }

    public String getName() {
        return name;
    }

    public String getPotentialDisease() {
        return potentialDisease;
    }

    public List<String> getMedications() {
        return medications;
    }

    public String getUsage() {
        return usage;
    }

    public static Prescription parse(JsonNode json) {
        String name = json.get("name").asText();
        String potentialDisease = json.get("potentialDisease").asText();
        List<String> medications = new java.util.ArrayList<>();
        for (JsonNode medNode : json.get("medications")) {
            medications.add(medNode.asText());
        }
        String usage = json.get("usage").asText();
        return new Prescription(name, potentialDisease, medications, usage);
    }
}