package prescribersystem.core.interfaces;

import prescribersystem.core.Demand;
import prescribersystem.core.Prescription;

import java.util.List;

public interface PrescribeHandler {
    Prescription handle(Demand demand, List<String> activeHandlers);
}
