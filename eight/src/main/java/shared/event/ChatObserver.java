package shared.event;

import modules.bot.contracts.BotEvent;
import shared.event.contracts.IEventObserver;

public class ChatObserver implements IEventObserver {
    @Override
    public void handle(BotEvent event) {
        System.out.println("Chatting about event: " + event);
    }
}
