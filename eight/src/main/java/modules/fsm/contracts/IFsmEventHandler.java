package modules.fsm.contracts;

public interface IFsmEventHandler {
    public void onTransition(IFsmState fromState, IFsmState toState, IFsmEvent event);
    public void onAction(IFsmState state);
}
