package modules.fsm.contracts;

public interface FsmGuard {
    public boolean evaluate(FsmEvent event);
}