package rpg.role.action;

import rpg.role.Role;
import rpg.role.state.PetrochemicalState;

import rpg.troop.Troop;
import java.util.List;

public class PetrochemicalSkill extends Action {

    private static final String NAME = "石化";

    private static final int MP_COST = 0;

    private static final int STR = 0;

    private static final int TARGET_COUNT = 1;

    public PetrochemicalSkill() {
        super(NAME, MP_COST, STR, TARGET_COUNT);
    }

    @Override
    protected void effect(Role target) {
        target.enterState(new PetrochemicalState());
    }
}
