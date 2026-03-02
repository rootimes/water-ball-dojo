package modules.bot.domain.command;

import modules.bot.contracts.BotEvent;

// 可以省略，練習一下
public abstract class CommandProxy {

    private boolean isAdmin;

    private final Command command;

    public CommandProxy(Command command) {
        this.command = command;
    }

    public void exec(BotEvent event) {
        if (isAuth()) {
            command.exec(event);
        }
    }

    protected boolean isAuth() {
        return isAdmin;
    }
}
