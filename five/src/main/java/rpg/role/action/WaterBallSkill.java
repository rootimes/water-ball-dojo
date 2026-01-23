package rpg.role.action;

import rpg.role.Role;

public class WaterBallSkill extends Action {

    public static final String NAME = "水球";

    public WaterBallSkill() {
        super(50, 120);
    }

    @Override
    protected void effect(Role target) {
        target.takeDamage(str);
    }
}
