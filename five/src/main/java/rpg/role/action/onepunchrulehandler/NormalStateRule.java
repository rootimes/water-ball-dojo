package rpg.role.action.onepunchrulehandler;

import rpg.role.Role;

public class NormalStateRule extends OnePunchRuleHandler {

    public NormalStateRule(OnePunchRuleHandler next) {
        super(next);
    }

    public void handle(Role target) {
        if (isNormalState(target)) {
            System.out.println("Handling Normal State Rule!");
        }

        if (next != null) {
            next.handle(target);
        }
    }

    private boolean isNormalState(Role target) {
        return target.getStateName().equals("NormalState");
    }
}
