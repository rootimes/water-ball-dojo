package shared.event.contracts;

public interface IEventObserver {
    public void handle(IEvent event);
}