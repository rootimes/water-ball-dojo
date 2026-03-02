package shared.event;

import modules.fsm.contracts.FsmEvent;
import modules.fsm.contracts.FsmState;
import shared.event.contracts.IEvent;

public class StateTransitionEvent implements IEvent {
    private final FsmState fromState;
    private final FsmState toState;
    private final FsmEvent event;

    public StateTransitionEvent(FsmState fromState, FsmState toState, FsmEvent event) {
        this.fromState = fromState;
        this.toState = toState;
        this.event = event;
    }

    public FsmState getFromState() {
        return fromState;
    }

    public FsmState getToState() {
        return toState;
    }

    public FsmEvent getEvent() {
        return event;
    }
}
