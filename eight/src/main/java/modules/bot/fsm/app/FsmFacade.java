package modules.bot.fsm.app;

import modules.bot.fsm.contracts.*;
import modules.bot.fsm.domain.FSM;
import modules.bot.fsm.domain.Transition;

public class FsmFacade {

    private final FSM fsm;

    public FsmFacade(FsmListener listener, FsmState state) {
        this.fsm = new FSM(listener, state);
    }

    public FsmState update(FsmState state, FsmEvent event) {
        return fsm.trigger(state, event);
    }

    public FsmFacade defineTransition(FsmState fromState, FsmGuard guard, FsmEvent event, FsmAction action,
            FsmState toState) {
        Transition transition = new Transition(fromState, guard, event, action, toState);
        fsm.addTransition(transition);
        return this;
    }
}
