package modules.fsm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modules.fsm.contracts.IFsmEvent;
import modules.fsm.contracts.IFsmObserver;
import modules.fsm.contracts.IFsmState;

public class FSM {

    private IFsmState currentState;

    private final IFsmObserver observer;

    private final Map<IFsmState, List<Transition>> transitions = new HashMap<>();

    public FSM(IFsmObserver observer, IFsmState state) {
        this.observer = observer;
        this.currentState = state;
        this.currentState.enter();
    }

    public void addTransition(Transition transition) {
        this.transitions
                .computeIfAbsent(transition.getFromState(), k -> new ArrayList<>())
                .add(transition);
    }

    public IFsmState trigger(IFsmState state, IFsmEvent event) {
        List<Transition> transitions = this.transitions.get(state);
        if (transitions == null) {
            return state;
        }

        for (Transition transition : transitions) {
            if (transition.isTriggeredBy(event) && transition.isGuardSatisfied(event)) {
                state.exit();
                transition.action(event);
                IFsmState toState = transition.getToState();
                toState.enter();
                this.currentState = toState;
                observer.onTransition(state, toState, event);
                return toState;
            }
        }
        return state;
    }
}
