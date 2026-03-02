package shared.event.contracts;

import java.util.function.Consumer;

public interface EventBus {
    
    void publish(IEvent event);

    <T extends IEvent> void subscribe(Class<T> eventType, Consumer<T> handler);
}
