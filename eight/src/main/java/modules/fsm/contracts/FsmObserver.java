package modules.fsm.contracts;

public interface FsmObserver {
    public void onTransition(FsmState fromState, FsmState toState, FsmEvent event);
    public void onAction(FsmState state);
}
