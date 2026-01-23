package rpg.role.action.onepunchrulehandler;

import rpg.role.Role;

public class HighHpRule extends OnePunchRuleHandler {

    private static final int STR = 300;

    public HighHpRule(OnePunchRuleHandler next) {
        super(next);
    }

    public void handle(Role target, Role self) {
        if (isHighHp(target)) {
            int damage = self.adjustDamage(STR);
            target.takeDamage(damage);
            return;
        }

        if (next != null) {
            next.handle(target, self);
        }
    }

    private boolean isHighHp(Role target) {
        return target.getHp() > 500;
    }

}
