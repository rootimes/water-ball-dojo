package modules.bot.domain.state;

import java.util.Arrays;
import java.util.List;

import modules.bot.contracts.IBotEvent;

public class DefaultBotState extends ChildState {

    private final List<String> types = Arrays.asList("new message", "new post");

    public DefaultBotState(ParentState parentState) {
        super(parentState);
    }
    @Override
    protected boolean matchEvent(IBotEvent event) {
        if (matchCommand(event)) {
            return true;
        }
        return event.matchType(types);
    }

    @Override
    protected void handle(IBotEvent event) {
        // TODO: implement handle logic
    }
}
