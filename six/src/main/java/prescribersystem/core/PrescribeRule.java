package prescribersystem.core;

import prescribersystem.core.interfaces.PrescribeHandler;

public abstract class PrescribeRule implements PrescribeHandler {

    protected PrescribeHandler next;

    public PrescribeRule(PrescribeHandler next) {
        this.next = next;
    }

    @Override
    public Prescription handle(PatientDatabase db, Demand demand) {
        Prescription prescription = prescribe(db, demand);

        if (prescription != null) {
            return prescription;
        }

        return next.handle(db, demand);
    }

    @Override
    public void setNext(PrescribeHandler next) {
        this.next = next;
    }

    protected abstract Prescription prescribe(PatientDatabase db, Demand demand);
}
