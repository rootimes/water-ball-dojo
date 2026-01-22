package rpg.role.action;

import rpg.role.Role;
import rpg.role.state.PoisonedState;

public class PoisonSkill extends Action {
    
    public PoisonSkill() {
        super(80, 0);
    }

    protected void effect(Role target) {
        target.enterState(new PoisonedState());
    }
}
