package modules.bot.fsm.contracts;

public interface FsmAction {
    public void execute(FsmEvent event);
}
