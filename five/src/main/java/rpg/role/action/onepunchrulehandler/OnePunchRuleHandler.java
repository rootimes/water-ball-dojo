package rpg.role.action.onepunchrulehandler;

public abstract class OnePunchRuleHandler {
    
    protected OnePunchRuleHandler next;

    public OnePunchRuleHandler(OnePunchRuleHandler next) {
        this.next = next;
    }

    abstract void handle(OnePunchRuleHandler handler);
}
