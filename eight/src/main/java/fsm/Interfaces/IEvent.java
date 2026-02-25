package fsm.Interfaces;

public interface IEvent {
    boolean match(IEvent event);
    boolean validate(IEvent event);
}
