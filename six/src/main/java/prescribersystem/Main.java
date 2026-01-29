package prescribersystem;

import java.util.Scanner;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        System.out.println("Enter supporting disease data:");

        String diseases = scanner.nextLine();

        PrescriberSystem prescriberSystem = new PrescriberSystem(diseases);

        System.out.println("Import patients data by json");

        String patients = new String(Files.readAllBytes(Paths.get("src/test/resource/AllPatients.json")));

        prescriberSystem.importPatients(patients);

        System.out.println("Enter demand patient ID:");

        String patientId = scanner.nextLine();

        System.out.println("Enter demand symptoms:");

        String symptoms = scanner.nextLine();

        System.out.println("Enter export path:");

        String path = scanner.nextLine();

        prescriberSystem.prescribe(patientId, symptoms, path);
    }
}