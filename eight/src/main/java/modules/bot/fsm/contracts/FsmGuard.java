package modules.bot.fsm.contracts;

public interface FsmGuard {
    public boolean evaluate(FsmEvent event);
}