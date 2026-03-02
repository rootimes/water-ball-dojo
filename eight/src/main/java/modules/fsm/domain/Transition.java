package modules.fsm.domain;

import modules.fsm.contracts.*;

public class Transition {
    final private FsmState fromState;
    final private FsmGuard guard;
    final private FsmEvent event;
    final private FsmAction action;
    final private FsmState toState;

    public Transition(
            FsmState fromState,
            FsmGuard guard,
            FsmEvent event,
            FsmAction action,
            FsmState toState) {
        this.fromState = fromState;
        this.guard = guard;
        this.event = event;
        this.action = action;
        this.toState = toState;
    }

    public FsmState getFromState() {
        return fromState;
    }

    public FsmGuard getGuard() {
        return guard;
    }

    public FsmAction getAction() {
        return action;
    }

    public FsmState getToState() {
        return toState;
    }

    public void action(FsmEvent event) {
        this.action.execute(event);
    }

    public boolean isTriggeredBy(FsmEvent event) {
        return this.event.evaluate(event);
    }

    public boolean isGuardSatisfied(FsmEvent event) {
        return this.guard.evaluate(event);
    }
}
