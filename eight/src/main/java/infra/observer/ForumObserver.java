package infra.observer;

import infra.observer.contracts.IEventObserver;
import modules.bot.contracts.IEvent;

public class ForumObserver implements IEventObserver {
    @Override
    public void handle(IEvent event) {
        System.out.println("Discussing event in forum: " + event);
    }
}
