package modules.bot.domain.state;

import modules.bot.contracts.IBotEvent;

public class NormalBotState extends ParentState {
    @Override
    public void handle(IBotEvent event) {
        if (event.evaluate()) {
        }
    }
}
