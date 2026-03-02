package modules.fsm.contracts;

public interface FsmEvent {
    public boolean evaluate(FsmEvent event);
}
