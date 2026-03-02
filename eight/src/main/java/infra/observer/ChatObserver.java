package infra.observer;

import infra.observer.contracts.IEventObserver;
import modules.bot.contracts.IEvent;

public class ChatObserver implements IEventObserver {
    @Override
    public void handle(IEvent event) {
        System.out.println("Chatting about event: " + event);
    }
}
