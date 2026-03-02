package shared.event;

import modules.bot.contracts.BotEvent;
import shared.event.contracts.IEventObserver;

public class ForumObserver implements IEventObserver {
    @Override
    public void handle(BotEvent event) {
        System.out.println("Discussing event in forum: " + event);
    }
}
