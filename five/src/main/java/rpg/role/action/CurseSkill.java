package rpg.role.action;

import rpg.role.Role;
import rpg.role.observer.CurseObserver;
import java.util.List;
import rpg.troop.Troop;

public class CurseSkill extends Action {

    private static final String NAME = "詛咒";

    private static final int MP_COST = 100;

    private static final int STR = 0;

    private static final int TARGET_COUNT = 1;

    public CurseSkill() {
        super(NAME, MP_COST, STR, TARGET_COUNT);
    }

    @Override
    public void handle(List<Role> targets, Role self) {
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
