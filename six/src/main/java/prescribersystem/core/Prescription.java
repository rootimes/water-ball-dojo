package prescribersystem.core;

import java.util.List;


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
}