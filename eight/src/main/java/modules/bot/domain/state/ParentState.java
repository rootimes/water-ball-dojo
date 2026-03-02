package modules.bot.domain.state;

import modules.bot.contracts.IBotEvent;
import modules.bot.contracts.IBotState;

import java.util.ArrayList;
import java.util.List;

import modules.bot.contracts.IBotCommand;

public abstract class ParentState implements IBotState {

    protected List<IBotCommand> commands = new ArrayList<>();

    public void enter() {
    }

    public void exit() {
    }

    public void handle(IBotEvent event) {
    }

    @Override
    public void registerCommand(IBotCommand command) {
        commands.add(command);
    }
}
