package prescribersystem;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter supporting disease data:");

        String diseases = scanner.nextLine();

        PrescriberSystem prescriberSystem = new PrescriberSystem(diseases);

        System.out.println("Import patients data by json:");

        String patientsData = scanner.nextLine();

        prescriberSystem.updatePatients(patientsData);

        System.out.println("Enter demand patient ID:");

        String patientId = scanner.nextLine();

        System.out.println("Enter demand symptoms:");

        String symptoms = scanner.nextLine();

        System.out.println("Enter export path:");

        String path = scanner.nextLine();

        prescriberSystem.prescribe(patientId, symptoms, path);
    }
}