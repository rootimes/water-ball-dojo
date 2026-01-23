package rpg.role.action;

import java.util.List;

import rpg.role.Role;

public class SelfExplosionSkill extends Action {

    private static final String NAME = "自爆";

    private static final int MP_COST = 150;

    private static final int STR = 200;

    private static final int TARGET_COUNT = Integer.MAX_VALUE;

    public SelfExplosionSkill() {
        super(NAME, MP_COST, STR, TARGET_COUNT);
    }

    @Override
    public void handle(List<Role> targets, Role self) {
        for (Role target : targets) {
            effect(target, self);
        }
        self.die();
    }

    @Override
    protected void effect(Role target, Role self) {
        target.takeDamage(self.adjustDamage(str));
    }
}
