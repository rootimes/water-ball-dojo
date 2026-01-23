package rpg.role.action.onepunchrulehandler;

import rpg.role.Role;

public class NormalStateRule extends OnePunchRuleHandler {

    private static final int STR = 100;

    public NormalStateRule(OnePunchRuleHandler next) {
        super(next);
    }

    public void handle(Role target, Role self) {
        if (isNormalState(target)) {
            int damage = self.adjustDamage(STR);
            target.takeDamage(damage);
            return;
        }

        if (next != null) {
            next.handle(target, self);
        }
    }

    private boolean isNormalState(Role target) {
        return target.getStateName().equals("NormalState");
    }
}
