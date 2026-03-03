package modules.bot.app.command;

import modules.bot.contracts.IBotCommand;
import modules.bot.contracts.IBotEvent;

// 可以省略，練習一下
public abstract class CommandProxy implements IBotCommand {

    private boolean onlyAdmin;

    private final Command command;

    public CommandProxy(Command command, boolean onlyAdmin) {
        this.command = command;
        this.onlyAdmin = onlyAdmin;
    }

    @Override
    public void exec(IBotEvent event) {
        if (isAuth(event)) {
            command.exec(event);
        }
    }

    protected abstract boolean isAuth(IBotEvent event);
}
