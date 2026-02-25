package fsm;

import fsm.Interfaces.*;

public class Transition {
    final private IState fromState;
    final private IGuard guard;
    final private IEvent event;
    final private IAction action;
    final private IState toState;

    public Transition(
            IState fromState,
            IGuard guard,
            IEvent event,
            IAction action,
            IState toState) {
        this.fromState = fromState;
        this.guard = guard;
        this.event = event;
        this.action = action;
        this.toState = toState;
    }

    public boolean guard(IEvent event) {
        // Implementation goes here
        return false;
    }
}
