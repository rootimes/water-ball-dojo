package prescribersystem.core.interfaces;

import java.io.PrintStream;

import prescribersystem.core.Case;
import prescribersystem.core.PatientDatabase;

public interface DoneObserver {
    void handle(PrintStream client, PatientDatabase db, Case caseData, String path);
}
