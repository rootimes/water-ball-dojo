package modules.fsm.contracts;

public interface FsmListener {
    public void onTransition(FsmState fromState, FsmState toState, FsmEvent event);
    public void onAction(FsmState state);
}
