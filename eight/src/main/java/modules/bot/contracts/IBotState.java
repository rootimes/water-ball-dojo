package modules.bot.contracts;

public interface IBotState {
    public void enter();

    public void exit();

    public void action(IBotEvent event);

    public void registerCommand(IBotCommand command, String commandKey);
}
