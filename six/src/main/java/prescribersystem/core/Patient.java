package prescribersystem.core;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public class Patient {

    private final String id;
    private final String name;
    private final int age;
    private final float height;
    private final float weight;
    private final List<Case> cases;

    public Patient(JsonNode json) {
        this.id = json.get("id").asText();
        this.name = json.get("name").asText();
        this.age = json.get("age").asInt();
        this.height = (float) json.get("height").asDouble();
        this.weight = (float) json.get("weight").asDouble();
        this.cases = new ArrayList<>();
        for (JsonNode caseNode : json.get("cases")) {
            this.cases.add(Case.parse(caseNode));
        }
    }

    public String getId() {
        return id;
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
}
