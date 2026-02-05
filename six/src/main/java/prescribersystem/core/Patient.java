package prescribersystem.core;

import java.util.List;


public class Patient {

    private final String id;
    private final String name;
    private final char gender;
    private final int age;
    private final float height;
    private final float weight;
    private final List<Case> cases;

    public Patient(String id, String name, char gender, int age, float height, float weight, List<Case> cases) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.cases = cases;
    }

    public String getName() {
        return name;
    }

    public List<Case> getCases() {
        return cases;
    }

    public String getId() {
        return id;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public void addCase(Case caseData) {
        this.cases.add(caseData);
    }
}
