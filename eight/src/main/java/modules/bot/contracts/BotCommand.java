package modules.bot.contracts;

public interface BotCommand {
    public void exec(BotEvent event);
}
