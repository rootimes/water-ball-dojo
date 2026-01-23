package rpg.role.action.onepunchrulehandler;

import rpg.role.Role;
import rpg.role.state.NormalState;

public class CheerUpStateRule extends OnePunchRuleHandler {

    private static final int STR = 100;

    public CheerUpStateRule(OnePunchRuleHandler next) {
        super(next);
    }

    public void handle(Role target, Role self) {
        if (isCheerUpState(target)) {
            int damage = self.adjustDamage(STR);
            target.takeDamage(damage);
            target.enterState(new NormalState());
            return;
        }
        
        if (next != null) {
            next.handle(target, self);
        }
    }

    private boolean isCheerUpState(Role target) {
        return target.getStateName().equals("CheerUpState");
    }
}
