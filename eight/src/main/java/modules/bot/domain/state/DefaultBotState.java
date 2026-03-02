package modules.bot.domain.state;

import modules.bot.contracts.IBotEvent;

public class DefaultBotState extends ChildState {
    public DefaultBotState(ParentState parentState) {
        super(parentState);
    }

    @Override
    public void handle(IBotEvent event) {
        if (event.evaluate()) {
        }
    }
}
