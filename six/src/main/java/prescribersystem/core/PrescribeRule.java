package prescribersystem.core;

import java.util.List;

import prescribersystem.core.interfaces.PrescribeHandler;

public abstract class PrescribeRule implements PrescribeHandler {

    protected PrescribeHandler next;

    public PrescribeRule(PrescribeHandler next) {
        this.next = next;
    }

    @Override
    public Prescription handle(Demand demand, List<String> activeHandlers) {
        if (shouldApply(activeHandlers)) {
            Prescription prescription = prescribe(demand);

            if (prescription != null) {
                return prescription;
            }
        }

        return next.handle(demand, activeHandlers);
    }

    protected abstract Prescription prescribe(Demand demand);

    protected abstract boolean shouldApply(List<String> activeHandlers);
}
