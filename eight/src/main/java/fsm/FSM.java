package fsm;

import fsm.Interfaces.IState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fsm.Interfaces.IEvent;

public class FSM {

    private final Map<IState, List<Transition>> transitions = new HashMap<>();

    public FSM(IState state) {
        state.enter();
    }

    public void addTransition(Transition transition) {
        this.transitions
                .computeIfAbsent(transition.getFromState(), k -> new ArrayList<>())
                .add(transition);
    }

    public IState trigger(IState state, IEvent event) {
        List<Transition> transitions = this.transitions.get(state);
        if (transitions == null) {
            return state;
        }

        for (Transition transition : transitions) {
            if (transition.isTriggeredBy(event) && transition.isGuardSatisfied(event)) {
                state.exit();
                transition.action(event);
                IState toState = transition.getToState();
                toState.enter();
                return toState;
            }
        }
        return state;
    }
}
