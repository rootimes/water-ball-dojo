package prescribersystem.core.interfaces;

import java.util.List;

import prescribersystem.core.Demand;
import prescribersystem.core.Prescription;

public interface PrescribeHandler {
    Prescription handle(Demand demand, List<String> activeHandlers);
}
