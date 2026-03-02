package modules.bot.fsm.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modules.bot.fsm.contracts.FsmEvent;
import modules.bot.fsm.contracts.FsmListener;
import modules.bot.fsm.contracts.FsmState;

public class FSM {

    private FsmState currentState;

    private final FsmListener listener;

    private final Map<FsmState, List<Transition>> transitions = new HashMap<>();

    public FSM(FsmListener listener, FsmState state) {
        this.listener = listener;
        this.currentState = state;
        this.currentState.enter();
    }

    public void addTransition(Transition transition) {
        this.transitions
                .computeIfAbsent(transition.getFromState(), k -> new ArrayList<>())
                .add(transition);
    }

    public FsmState trigger(FsmState state, FsmEvent event) {
        List<Transition> transitions = this.transitions.get(state);
        if (transitions == null) {
            return state;
        }

        for (Transition transition : transitions) {
            if (transition.isTriggeredBy(event) && transition.isGuardSatisfied(event)) {
                state.exit();
                transition.action(event);
                FsmState toState = transition.getToState();
                toState.enter();
                this.currentState = toState;
                return toState;
            }
        }
        return state;
    }
}
