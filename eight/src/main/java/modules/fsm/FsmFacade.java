package modules.fsm;

import modules.fsm.contracts.*;

public class FsmFacade {

    private final FSM fsm;

    public FsmFacade(FsmObserver observer, FsmState state) {
        this.fsm = new FSM(observer, state);
    }

    public FsmState update(FsmState state, FsmEvent event) {
        return fsm.trigger(state, event);
    }

    public FsmFacade defineTransition(FsmState fromState, FsmGuard guard, FsmEvent event,
            FsmAction action, FsmState toState) {
        Transition transition = new Transition(fromState, guard, event, action, toState);
        fsm.addTransition(transition);
        return this;
    }
}
