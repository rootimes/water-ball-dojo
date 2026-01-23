package rpg.role.action;

import rpg.role.Role;
import rpg.troop.Troop;
import java.util.List;

public class FireBallSkill extends Action {

    private static final String NAME = "火球";

    private static final int MP_COST = 50;

    private static final int STR = 50;

    private static final int TARGET_COUNT = 1;

    public FireBallSkill() {
        super(NAME, MP_COST, STR, TARGET_COUNT);
    }

    @Override
    protected void effect(Role target, Role self) {
        int damage = self.adjustDamage(STR);
        target.takeDamage(damage);
    }
}
