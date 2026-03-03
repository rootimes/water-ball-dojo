package modules.bot.app.command;

import modules.bot.contracts.IBotCommand;
import modules.bot.contracts.IBotEventHandler;
import modules.bot.contracts.IBotEvent;

public abstract class Command implements IBotCommand {

    protected int quota;

    protected final IBotEventHandler dispatcher;

    public Command(IBotEventHandler dispatcher, int quota) {
        this.dispatcher = dispatcher;
        this.quota = quota;
    }

    public int getQuota() {
        return quota;
    }

    @Override
    public void exec(IBotEvent event) {
        dispatch(event);
        decreaseQuota();
    }

    protected void decreaseQuota() {
        if (quota > 0) {
            quota--;
        }
    }

    protected abstract void dispatch(IBotEvent event);
}
