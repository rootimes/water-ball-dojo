package modules.bot.domain.command;

import modules.bot.contracts.BotEvent;
import modules.bot.contracts.BotObserver;

public abstract class Command {

    protected final String key;

    protected int quota;

    protected final BotObserver observer;

    public Command(BotObserver observer, String key, int quota) {
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

    public void exec(BotEvent event) {
        dispatch(event);
        decreaseQuota();
    }

    protected abstract void dispatch(BotEvent event);

    private void decreaseQuota() {
        if (quota > 0) {
            quota--;
        }
    }
}
