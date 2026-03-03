package modules.bot.app.command;

import modules.bot.contracts.IBotEvent;
import modules.bot.domain.EventDispatcher;

public abstract class Command {

    protected final String key;

    protected int quota;

    protected final EventDispatcher eventDispatcher;

    public Command(EventDispatcher eventDispatcher, String key, int quota) {
        this.eventDispatcher = eventDispatcher;
        this.key = key;
        this.quota = quota;
    }

    public String getKey() {
        return key;
    }

    public int getQuota() {
        return quota;
    }

    public void exec(IBotEvent event) {
        dispatch(event);
        decreaseQuota();
    }

    protected abstract void dispatch(IBotEvent event);

    private void decreaseQuota() {
        if (quota > 0) {
            quota--;
        }
    }
}
