package prescribersystem.core;


import prescribersystem.core.interfaces.PrescribeHandler;

public abstract class PrescribeRule implements PrescribeHandler {

    protected PrescribeHandler next;

    public PrescribeRule(PrescribeHandler next) {
        this.next = next;
    }

    @Override
    public Prescription handle(Demand demand) {
        Prescription prescription = prescribe(demand);

        if (prescription != null) {
            return prescription;
        }

        return next.handle(demand);
    }

    @Override
    public void setNext(PrescribeHandler next) {
        this.next = next;
    }

    protected abstract Prescription prescribe(Demand demand);
}
