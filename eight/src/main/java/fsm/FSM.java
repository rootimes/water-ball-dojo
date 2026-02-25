package fsm;

import java.util.Map;
import fsm.Interfaces.IState;
import fsm.Interfaces.IEvent;

public class FSM {

    private Map<IState, Transition> transitions;

    public IState update(IState state, IEvent event) {
        // Implementation goes here
        return null;
    }

    private IState trigger(IState state, IEvent event) {
        // Implementation goes here
        return null;
    }
}
