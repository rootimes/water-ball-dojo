package modules.bot.contracts;

public interface IBotCommand {
    public void exec(IBotEvent event);
}
