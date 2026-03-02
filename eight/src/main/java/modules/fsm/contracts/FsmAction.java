package modules.fsm.contracts;

public interface FsmAction {
    public void execute(FsmEvent event);
}
