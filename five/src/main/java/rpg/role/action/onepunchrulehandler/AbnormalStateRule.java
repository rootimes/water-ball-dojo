package rpg.role.action.onepunchrulehandler;

public class AbnormalStateRule extends OnePunchRuleHandler {

    public AbnormalStateRule(OnePunchRuleHandler next) {
        super(next);
    }

    public void handle(OnePunchRuleHandler handler) {
        System.out.println("Handling Abnormal State Rule!");

        if (next != null) {
            next.handle(handler);
        }
    }

}
