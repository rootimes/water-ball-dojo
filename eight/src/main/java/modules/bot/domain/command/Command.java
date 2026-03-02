package modules.bot.domain.command;

import modules.bot.contracts.IBotEvent;
import modules.bot.contracts.IBotObserver;

public abstract class Command {

    protected final String key;

    protected int quota;

    protected final IBotObserver observer;

    public Command(IBotObserver observer, String key, int quota) {
        this.observer = observer;
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
