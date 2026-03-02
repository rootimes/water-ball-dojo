package modules.fsm.contracts;

public interface IGuard {
    public boolean evaluate(IEvent event);
}