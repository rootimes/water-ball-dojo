package rpg.role.action;

import java.util.List;
import rpg.role.Role;

public class SelfHealingSkill extends Action {

    public static final String NAME = "自我治療";

    public SelfHealingSkill() {
        super(50, 150);
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
