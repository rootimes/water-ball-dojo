package observer.interfaces;

import bot.interfaces.IEvent;

public interface IEventObserver {
    public void handle(IEvent event);
}
