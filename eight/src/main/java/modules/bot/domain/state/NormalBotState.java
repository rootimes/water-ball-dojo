package modules.bot.domain.state;

import java.util.List;

import modules.bot.contracts.IBotEvent;

public class NormalBotState extends ParentState {

    private final List<String> eventNames = List.of("normal");

    @Override
    public void enter() {

    }

    @Override
    public void exit() {

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
