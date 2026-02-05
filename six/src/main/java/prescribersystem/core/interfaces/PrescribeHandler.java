package prescribersystem.core.interfaces;

import prescribersystem.core.Demand;
import prescribersystem.core.Prescription;

public interface PrescribeHandler {
    Prescription handle(Demand demand);

    void setNext(PrescribeHandler next);
}
