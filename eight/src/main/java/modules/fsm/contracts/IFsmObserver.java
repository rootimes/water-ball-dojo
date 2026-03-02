package modules.fsm.contracts;

public interface IFsmObserver {
    public void onTransition(IFsmState fromState, IFsmState toState, IFsmEvent event);
    public void onAction(IFsmState state);
}
