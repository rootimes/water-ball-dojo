package modules.fsm;

import modules.fsm.contracts.*;

public class Transition {
    final private IFsmState fromState;
    final private IFsmGuard guard;
    final private IFsmEvent event;
    final private IFsmAction action;
    final private IFsmState toState;

    public Transition(
            IFsmState fromState,
            IFsmGuard guard,
            IFsmEvent event,
            IFsmAction action,
            IFsmState toState) {
        this.fromState = fromState;
        this.guard = guard;
        this.event = event;
        this.action = action;
        this.toState = toState;
    }

    public IFsmState getFromState() {
        return fromState;
    }

    public IFsmGuard getGuard() {
        return guard;
    }

    public IFsmAction getAction() {
        return action;
    }

    public IFsmState getToState() {
        return toState;
    }

    public void action(IFsmEvent event) {
        this.action.execute(event);
    }

    public boolean isTriggeredBy(IFsmEvent event) {
        return this.event.evaluate();
    }

    public boolean isGuardSatisfied(IFsmEvent event) {
        return this.guard.evaluate(event);
    }
}
