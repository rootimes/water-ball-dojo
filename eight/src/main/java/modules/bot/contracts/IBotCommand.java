package modules.bot.contracts;

import modules.bot.domain.ComContext;

public interface IBotCommand {
    public void exec(IBotEvent event, ComContext info);
}
