package fsm.Interfaces;

public interface IGuard {
    public boolean evaluate(IEvent event);
}