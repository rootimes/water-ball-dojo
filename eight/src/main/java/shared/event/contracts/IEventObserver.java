package shared.event.contracts;

import modules.bot.contracts.BotEvent;

public interface IEventObserver {
    public void handle(BotEvent event);
}
