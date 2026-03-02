package modules.fsm.contracts;

public interface IEvent {
    boolean evaluate(IEvent event);
    boolean validate(IEvent event);
}
