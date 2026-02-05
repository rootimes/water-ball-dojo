package prescribersystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        String diseases = new String(Files.readAllBytes(Paths.get("src/test/resource/SupportDiseases.in")));

        PrescriberSystem prescriberSystem = new PrescriberSystem(diseases);

        String patients = new String(Files.readAllBytes(Paths.get("src/test/resource/AllPatients.json")));

        prescriberSystem.importPatients(patients);

        System.out.println("Prescribe System is running");

        String cmd = "";
        do {
            System.out.println("Enter demand patient ID:");
            String patientId = scanner.nextLine().trim();

            System.out.println("Enter demand symptoms:");
            String symptoms = scanner.nextLine().trim();

            System.out.println("Enter export path:");
            String path = scanner.nextLine().trim();

            try {
                prescriberSystem.prescribe(patientId, symptoms, path);
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }

            System.out.println("Type 'exit' to stop, or press Enter to continue:");
            cmd = scanner.nextLine().trim();

        } while (!"exit".equalsIgnoreCase(cmd));
    }
}