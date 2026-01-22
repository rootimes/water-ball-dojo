package rpg.role.action.onepunchrulehandler;

public class CheerUpStateRule extends OnePunchRuleHandler {

    public CheerUpStateRule(OnePunchRuleHandler next) {
        super(next);
    }

    public void handle(OnePunchRuleHandler handler) {
        System.out.println("Handling Cheer Up State Rule!");

        if (next != null) {
            next.handle(handler);
        }
    }

}
