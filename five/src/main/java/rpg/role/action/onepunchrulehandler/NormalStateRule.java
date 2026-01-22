package rpg.role.action.onepunchrulehandler;

public class NormalStateRule extends OnePunchRuleHandler {

    public NormalStateRule(OnePunchRuleHandler next) {
        super(next);
    }

    public void handle(OnePunchRuleHandler handler) {
        System.out.println("Handling Normal State Rule!");

        if (next != null) {
            next.handle(handler);
        }
    }
}
