package modules.fsm.contracts;

public interface IFsmGuard {
    public boolean evaluate(IFsmEvent event);
}