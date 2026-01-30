package prescribersystem.observers;

import java.io.PrintStream;

import prescribersystem.core.Case;
import prescribersystem.core.PatientDatabase;
import prescribersystem.core.interfaces.DoneObserver;

public class NotifyClientObserver implements DoneObserver {

    @Override
    public void handle(PrintStream client, PatientDatabase patientDatabase, Case caseData, String path) {

        String patientId = caseData.getPatientId();
        patientDatabase.getPatientName(patientId);

        client.println("Case for patient " + caseData.getPatientId() + " has been stored successfully.");
    }
}
