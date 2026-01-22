package rpg.role.action;

import rpg.role.Role;

public class BasicAttack extends Action {
    public BasicAttack(int str) {
        super(0, str);
    }

    @Override
    protected void effect(Role target) {
        target.takeDamage(str);
    }
}