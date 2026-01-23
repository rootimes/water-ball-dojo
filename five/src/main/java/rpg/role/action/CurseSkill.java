package rpg.role.action;

import rpg.role.Role;
import rpg.role.observer.CurseObserver;
import java.util.List;

public class CurseSkill extends Action {

    public static final String NAME = "詛咒";

    public CurseSkill() {
        super(100, 0);
    }

    @Override
    public void handle(List<Role> targets, Role self) {
        self.consumeMp(mp);
        for (Role target : targets) {
            effect(target, self);
        }
    }

    public void effect(Role target, Role caster) {
        target.registerDeathObserver(new CurseObserver(caster), caster);
    }

    @Override
    public void effect(Role target) {
        // No direct effect on the target when the curse is applied
    }

}
