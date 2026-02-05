package prescribersystem.core.interfaces;

import prescribersystem.core.Demand;
import prescribersystem.core.PatientDatabase;
import prescribersystem.core.Prescription;

public interface PrescribeHandler {
    Prescription handle(PatientDatabase db, Demand demand);

    void setNext(PrescribeHandler next);
}
