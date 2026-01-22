package rpg.role.action;

import java.util.List;

import rpg.role.Role;

public class SelfExplosionSkill extends Action {

    public SelfExplosionSkill() {
        super(200, 150);
    }

    @Override
    public void handle(List<Role> targets, Role self) {
        self.consumeMp(mp);
        self.die();
        for (Role target : targets) {
            effect(target);
        }
    }

    @Override
    protected void effect(Role target) {
        target.takeDamage(str);
    }
}
