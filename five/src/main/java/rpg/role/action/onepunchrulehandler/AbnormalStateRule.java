package rpg.role.action.onepunchrulehandler;

import java.util.List;

import rpg.role.Role;

public class AbnormalStateRule extends OnePunchRuleHandler {

    private static final int STR = 80;

    public AbnormalStateRule(OnePunchRuleHandler next) {
        super(next);
    }

    public void handle(Role target, Role self) {
        if (isAbnormalState(target)) {
            for (int i = 0; i < 3; i++) {
                int damage = self.adjustDamage(STR);
                target.takeDamage(damage);
            }
            return;
        }

        if (next != null) {
            next.handle(target, self);
        }
    }

    private boolean isAbnormalState(Role target) {
        List<String> abnormalStates = List.of("PoisonedState", "PetrochemicalState");
        return abnormalStates.contains(target.getStateName());
    }
}
