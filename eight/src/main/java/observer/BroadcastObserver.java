package observer;

import observer.interfaces.IEventObserver;
import bot.interfaces.IEvent;

public class BroadcastObserver implements IEventObserver {

    @Override
    public void handle(IEvent event) {
        System.out.println("Broadcasting event: " + event);
    }
}
