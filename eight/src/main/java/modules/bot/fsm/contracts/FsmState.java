package modules.bot.fsm.contracts;

public interface FsmState {
    void enter();
    void exit();
}
