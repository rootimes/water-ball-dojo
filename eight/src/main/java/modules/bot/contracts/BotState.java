package modules.bot.contracts;

public interface BotState {
    public void registerCommand(BotCommand command);

    public void enter();

    public void exit();

    public void handle(BotEvent event);
}
