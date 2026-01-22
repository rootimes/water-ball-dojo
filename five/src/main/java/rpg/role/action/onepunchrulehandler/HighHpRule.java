package rpg.role.action.onepunchrulehandler;

public class HighHpRule extends OnePunchRuleHandler {

    public HighHpRule(OnePunchRuleHandler next) {
        super(next);
    }

    public void handle(OnePunchRuleHandler handler) {
        System.out.println("Handling High HP Rule!");

        if (next != null) {
            next.handle(handler);
        }
    }
    
}
