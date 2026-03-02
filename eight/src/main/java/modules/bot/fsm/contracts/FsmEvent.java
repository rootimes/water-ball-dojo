package modules.bot.fsm.contracts;

public interface FsmEvent {
    public boolean evaluate(FsmEvent event);
}
