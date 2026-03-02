package modules.bot.domain.state;

import modules.bot.contracts.IBotCommand;
import modules.bot.contracts.IBotEvent;
import modules.bot.contracts.IBotState;

import java.util.ArrayList;
import java.util.List;

public abstract class ChildState implements IBotState {

    protected ParentState IState;

    protected List<IBotCommand> commands = new ArrayList<>();

    public ChildState(ParentState parentState) {
        this.IState = parentState;
    }

    public void enter() {
    }

    public void exit() {
        IState.exit();
    }

    public void handle(IBotEvent event) {
    }

    @Override
    public void registerCommand(IBotCommand command) {
        commands.add(command);
    }
}
