package prescribersystem.observers;

import java.io.PrintStream;

import prescribersystem.core.Case;
import prescribersystem.core.PatientDatabase;
import prescribersystem.core.interfaces.DoneObserver;

public class StoreCaseObserver implements DoneObserver {

    @Override
    public void handle(PrintStream client, PatientDatabase patientDatabase, Case caseData, String path) {
        patientDatabase.storeCase(caseData);
    }
}
