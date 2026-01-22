package rpg.role.action.onepunchrulehandler;

import rpg.role.Role;
import rpg.role.state.NormalState;

public class CheerUpStateRule extends OnePunchRuleHandler {

    public CheerUpStateRule(OnePunchRuleHandler next) {
        super(next);
    }

    public void handle(Role target) {
        if (isCheerUpState(target)) {
            target.takeDamage(100);
            target.enterState(new NormalState());
            return;
        }
        if (next != null) {
            next.handle(target);
        }
    }

    private boolean isCheerUpState(Role target) {
        return target.getStateName().equals("CheerUpState");
    }
}
