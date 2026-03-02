package shared.event;

import shared.event.contracts.IEvent;
import shared.event.contracts.IEventObserver;

public class ChatObserver implements IEventObserver {
    @Override
    public void handle(IEvent event) {
        System.out.println("Chatting about event: " + event);
    }
}
