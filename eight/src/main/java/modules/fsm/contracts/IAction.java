package modules.fsm.contracts;

public interface IAction {
    public void execute(IEvent event);
}
