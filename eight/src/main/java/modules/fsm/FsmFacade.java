package modules.fsm;

import modules.fsm.contracts.*;

public class FsmFacade {

    private final FSM fsm;

    public FsmFacade(IFsmEventHandler observer, IFsmState state) {
        this.fsm = new FSM(observer, state);
    }

    public IFsmState update(IFsmState state, IFsmEvent event) {
        return fsm.trigger(state, event);
    }

    public FsmFacade defineTransition(IFsmState fromState, IFsmGuard guard, IFsmEvent event,
            IFsmAction action, IFsmState toState) {
        Transition transition = new Transition(fromState, guard, event, action, toState);
        fsm.addTransition(transition);
        return this;
    }
}
