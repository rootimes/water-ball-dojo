package observer;

import observer.interfaces.IEventObserver;
import bot.interfaces.IEvent;

public class ForumObserver implements IEventObserver {
    @Override
    public void handle(IEvent event) {
        System.out.println("Discussing event in forum: " + event);
    }
}
