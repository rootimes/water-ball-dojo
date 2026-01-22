package rpg.role.action.onepunchrulehandler;

import rpg.role.Role;

public class HighHpRule extends OnePunchRuleHandler {

    private static final int STR = 300;

    public HighHpRule(OnePunchRuleHandler next) {
        super(next);
    }

    public void handle(Role target) {
        if (isHighHp(target)) {
            target.takeDamage(STR);
            return;
        }

        if (next != null) {
            next.handle(target);
        }
    }

    private boolean isHighHp(Role target) {
        return target.getHp() > 500;
    }

}
