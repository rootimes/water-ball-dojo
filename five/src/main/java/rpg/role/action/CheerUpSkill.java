package rpg.role.action;

import rpg.role.Role;
import rpg.role.state.CheerUpState;

public class CheerUpSkill extends Action {

    public CheerUpSkill() {
        super(100, 0);
    }

    public void effect(Role target) {
        target.enterState(new CheerUpState());
    }
}
