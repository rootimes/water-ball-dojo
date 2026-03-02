package modules.fsm.app;

import modules.fsm.contracts.*;
import modules.fsm.domain.FSM;
import modules.fsm.domain.Transition;

public class FsmFacade {

    private final FSM fsm;

    public FsmFacade(FsmState state) {
        this.fsm = new FSM(state);
    }

    public FsmState update(FsmState state, FsmEvent event) {
        return fsm.trigger(state, event);
    }

    public FsmFacade defineTransition(FsmState fromState, FsmGuard guard, FsmEvent event, FsmAction action, FsmState toState) {
        Transition transition = new Transition(fromState, guard, event, action, toState);
        fsm.addTransition(transition);
        return this;
    }
}
