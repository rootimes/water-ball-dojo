package rpg.role.action;

import rpg.role.Role;

public class FireBallSkill extends Action {

    public FireBallSkill() {
        super(50, 50);
    }

    @Override
    protected void effect(Role target) {
        target.takeDamage(str);
    }
}
