package shared.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import shared.event.contracts.EventBus;
import shared.event.contracts.IEvent;


public class SimpleEventBus implements EventBus {

    private final Map<Class<? extends IEvent>, List<Consumer<?>>> subscribers = new HashMap<>();

    @Override
    public void publish(IEvent event) {
        Class<? extends IEvent> eventType = event.getClass();

        if (subscribers.containsKey(eventType)) {
            subscribers.get(eventType).forEach(handler -> {
                @SuppressWarnings("unchecked")
                Consumer<IEvent> castedHandler = (Consumer<IEvent>) handler;
                castedHandler.accept(event);
            });
        }
    }

    @Override
    public <T extends IEvent> void subscribe(Class<T> eventType, Consumer<T> handler) {
        subscribers.computeIfAbsent(eventType, k -> new ArrayList<>()).add(handler);
    }
}
