package modules.bot.domain.state;

import java.util.List;

import modules.bot.contracts.IBotEvent;

public class NormalBotState extends ParentState {

    private final List<String> types = List.of("normal");

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
        return event.matchType(types);
    }

    @Override
    protected void handle(IBotEvent event) {
        // TODO: implement handle logic
    }
}
