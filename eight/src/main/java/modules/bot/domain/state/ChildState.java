package modules.bot.domain.state;

import modules.bot.contracts.BotEvent;
import modules.bot.contracts.BotState;

public abstract class ChildState implements BotState {
    private ParentState IState;

    public ChildState(ParentState parentState) {
        this.IState = parentState;
    }

    public void enter() {
    }

    public void exit() {
        IState.exit();
    }

    public void handle(BotEvent event) {
    }
}
