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

    public IState getFromState() {
        return fromState;
    }

    public IGuard getGuard() {
        return guard;
    }

    public IAction getAction() {
        return action;
    }

    public IState getToState() {
        return toState;
    }

    public void action(IEvent event) {
        this.action.execute(event);
    }

    public boolean isTriggeredBy(IEvent event) {
        return this.event.evaluate(event);
    }

    public boolean isGuardSatisfied(IEvent event) {
        return this.guard.evaluate(event);
    }
}
