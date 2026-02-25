package fsm;

import fsm.Interfaces.*;

public class FsmFacade {

    public IState update(IState state, IEvent event) {
        // Implementation goes here
        return null;
    }

    public IState defineState(IState state) {
        // Implementation goes here
        return null;
    }

    public Transition defineTransition(IState fromState, IGuard guard, IEvent event, IAction action, IState toState) {
        return new Transition(fromState, guard, event, action, toState);
    }

    public void defineFSM() {
        // Implementation goes here
    }
}
