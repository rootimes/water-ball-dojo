package rpg.role.action;

import rpg.role.Role;

public class WaterBallSkill extends Action {
    public WaterBallSkill() {
        super(50, 120);
    }

    @Override
    protected void effect(Role target) {
        target.takeDamage(str);
    }
}
