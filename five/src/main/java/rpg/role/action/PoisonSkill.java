package rpg.role.action;

import rpg.role.Role;
import rpg.role.state.PoisonedState;

public class PoisonSkill extends Action {
    
    private static final String NAME = "下毒";

    private static final int MP_COST = 80;

    private static final int STR = 0;

    private static final int TARGET_COUNT = 1;
    
    public PoisonSkill() {
        super(NAME, MP_COST, STR, TARGET_COUNT);
    }

    protected void effect(Role target) {
        target.enterState(new PoisonedState());
    }
}
