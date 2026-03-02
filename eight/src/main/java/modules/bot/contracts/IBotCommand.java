package modules.bot.contracts;

import modules.bot.shared.ComContext;

public interface IBotCommand {
    public void exec(IBotEvent event, ComContext info);
}
