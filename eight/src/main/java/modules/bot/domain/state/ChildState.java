package modules.bot.domain.state;

import java.util.HashMap;
import java.util.Map;

import modules.bot.contracts.IBotCommand;
import modules.bot.contracts.IBotEvent;
import modules.bot.contracts.IBotState;

public abstract class ChildState implements IBotState {

    protected ParentState IState;

    protected Map<String, IBotCommand> commands = new HashMap<>();

    public ChildState(ParentState parentState) {
        this.IState = parentState;
    }

    @Override
    public void enter() {
    }

    @Override
    public void action(IBotEvent event) {
        if (matchEvent(event)) {
            this.handle(event);
        }
    }

    @Override
    public void exit() {
        IState.exit();
    }

    @Override
    public void registerCommand(IBotCommand command, String commandKey) {
        commands.put(commandKey, command);
    }

    protected abstract boolean matchEvent(IBotEvent event);

    protected boolean matchCommand(IBotEvent event) {
        String commandKey = (String) event.getPayload("command");
        return commands.containsKey(commandKey);
    }

    protected abstract void handle(IBotEvent event);
}
