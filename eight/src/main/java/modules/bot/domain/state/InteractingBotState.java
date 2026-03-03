package modules.bot.domain.state;

import java.util.Arrays;
import java.util.List;

import modules.bot.contracts.IBotEvent;

public class InteractingBotState extends ChildState {

    private final List<String> eventNames = Arrays.asList("new message", "new post");

    public InteractingBotState(ParentState parent) {
        super(parent);
    }

    @Override
    protected boolean matchEvent(IBotEvent event) {
        if (matchCommand(event)) {
            return true;
        }
        return event.matchName(eventNames);
    }

    @Override
    protected void handle(IBotEvent event) {
        // TODO: implement handle logic
    }
}
