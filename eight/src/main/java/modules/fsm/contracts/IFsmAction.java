package modules.fsm.contracts;

public interface IFsmAction {
    public void execute(IFsmEvent event);
}
