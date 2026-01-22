package rpg.role.action.onepunchrulehandler;

import java.util.List;

import rpg.role.Role;

public class AbnormalStateRule extends OnePunchRuleHandler {

    public AbnormalStateRule(OnePunchRuleHandler next) {
        super(next);
    }

    public void handle(Role target) {
        if (isAbnormalState(target)) {
            for (int i = 0; i < 3; i++) {
                target.takeDamage(80);
            }
        }

        if (next != null) {
            next.handle(target);
        }
    }

    private boolean isAbnormalState(Role target) {
        List<String> abnormalStates = List.of("PoisonedState", "PetrochemicalState");
        return abnormalStates.contains(target.getStateName());
    }
}
