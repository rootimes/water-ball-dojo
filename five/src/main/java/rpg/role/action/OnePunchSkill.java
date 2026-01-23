package rpg.role.action;

import rpg.role.Role;
import rpg.role.action.onepunchrulehandler.AbnormalStateRule;
import rpg.role.action.onepunchrulehandler.CheerUpStateRule;
import rpg.role.action.onepunchrulehandler.HighHpRule;
import rpg.role.action.onepunchrulehandler.NormalStateRule;

public class OnePunchSkill extends Action {

    public static final String NAME = "一拳攻擊";

    public OnePunchSkill() {
        super(180, 0);
    }

    @Override
    public void effect(Role target) {
        new HighHpRule(new AbnormalStateRule(new CheerUpStateRule(new NormalStateRule(null)))).handle(target);
    }
}
