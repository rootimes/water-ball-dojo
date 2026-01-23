package rpg.role.action;

import java.util.List;
import rpg.role.Role;
import rpg.troop.Troop;

public class SelfHealingSkill extends Action {

    private static final String NAME = "自我治療";

    private static final int MP_COST = 50;

    private static final int STR = 150;

    private static final int TARGET_COUNT = Integer.MAX_VALUE;

    public SelfHealingSkill() {
        super(NAME, MP_COST, STR, TARGET_COUNT);
    }

    @Override
    public List<Role> getCandidates(List<Troop> troops, Role self) {
        return List.of(self);
    }

    @Override
    public void handle(List<Role> targets, Role self) {
        self.consumeMp(mp);
        effect(self);
    }

    @Override
    protected void effect(Role self) {
        self.heal(str);
    }
}
