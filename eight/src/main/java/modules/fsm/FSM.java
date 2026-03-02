package modules.fsm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modules.fsm.contracts.FsmEvent;
import modules.fsm.contracts.FsmObserver;
import modules.fsm.contracts.FsmState;

public class FSM {

    private FsmState currentState;

    private final FsmObserver observer;

    private final Map<FsmState, List<Transition>> transitions = new HashMap<>();

    public FSM(FsmObserver observer, FsmState state) {
        this.observer = observer;
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
                observer.onTransition(state, toState, event);
                return toState;
            }
        }
        return state;
    }
}
