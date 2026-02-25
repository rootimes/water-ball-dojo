package fsm;

import fsm.Interfaces.*;

public class FsmFacade {

    private final FSM fsm;

    public FsmFacade(IState state) {
        this.fsm = new FSM(state);
    }

    public IState update(IState state, IEvent event) {
        return fsm.trigger(state, event);
    }

    public FsmFacade defineTransition(IState fromState, IGuard guard, IEvent event, IAction action, IState toState) {
        Transition transition = new Transition(fromState, guard, event, action, toState);
        fsm.addTransition(transition);
        return this;
    }
}
