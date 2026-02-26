package observer;

import observer.interfaces.IEventObserver;
import bot.interfaces.IEvent;

public class ChatObserver implements IEventObserver{
    @Override
    public void handle(IEvent event) {
        System.out.println("Chatting about event: " + event);
    }
}
