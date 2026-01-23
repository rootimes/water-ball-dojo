package rpg.role.action;

import rpg.role.Role;
import rpg.role.state.CheerUpState;
import rpg.troop.Troop;
import java.util.List;

public class CheerUpSkill extends Action {

    private static final String NAME = "鼓舞";

    private static final int MP_COST = 100;

    private static final int STR = 0;

    private static final int TARGET_COUNT = 3;

    public CheerUpSkill() {
        super(NAME, MP_COST, STR, TARGET_COUNT);
    }

    @Override
    public List<Role> getCandidates(List<Troop> troops, Role self) {
        Troop ownTroop = self.getTroop();

        List<Role> allies = ownTroop.getAliveRoles();
        allies.remove(self);

        return allies;
    }

    public void effect(Role target) {
        target.enterState(new CheerUpState());
    }
}
