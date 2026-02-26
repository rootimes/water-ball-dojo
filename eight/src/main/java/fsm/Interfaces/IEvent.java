package fsm.Interfaces;

public interface IEvent {
    boolean evaluate(IEvent event);
    boolean validate(IEvent event);
}
