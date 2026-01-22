package rpg.role.action;

import rpg.role.Role;
import rpg.role.state.PetrochemicalState;

public class PetrochemicalSkill extends Action {
    
    public PetrochemicalSkill() {
        super(100, 0);
    }

    @Override
    protected void effect(Role target) {
        target.enterState(new PetrochemicalState());
    }
}
