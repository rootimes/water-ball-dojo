package shared.event;

import shared.event.contracts.IEvent;
import shared.event.contracts.IEventObserver;

public class ForumObserver implements IEventObserver {
    @Override
    public void handle(IEvent event) {
        System.out.println("Discussing event in forum: " + event);
    }
}
