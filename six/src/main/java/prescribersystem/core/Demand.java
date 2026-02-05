package prescribersystem.core;

import java.io.PrintStream;
import java.util.List;

import prescribersystem.SymptomEnum;

public class Demand {

    private String patientId;
    private List<SymptomEnum> symptoms;
    private String path;
    private PrintStream client;

    public Demand(PrintStream client, String patientId,
            List<SymptomEnum> symptoms, String path) {
        this.patientId = patientId;
        this.path = path;
        this.client = client;
        this.symptoms = symptoms;
    }

    public String getPatientId() {
        return patientId;
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

}
