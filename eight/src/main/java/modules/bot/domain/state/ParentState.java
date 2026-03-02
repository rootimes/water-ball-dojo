package modules.bot.domain.state;

import modules.bot.contracts.BotEvent;
import modules.bot.contracts.BotState;

public abstract class ParentState implements BotState {
    public void enter() {
    }

    public void exit() {
    }

    public void handle(BotEvent event) {
    }
}
