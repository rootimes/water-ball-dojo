package infra.observer.contracts;

import modules.bot.contracts.IEvent;

public interface IEventObserver {
    public void handle(IEvent event);
}
