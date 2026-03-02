package shared.event;

import shared.event.contracts.IEvent;
import shared.event.contracts.IEventObserver;

public class BroadcastObserver implements IEventObserver {

    @Override
    public void handle(IEvent event) {
        System.out.println("Broadcasting event: " + event);
    }
}
