package rpg.role.action;

import rpg.role.Role;
import rpg.role.action.onepunchrulehandler.AbnormalStateRule;
import rpg.role.action.onepunchrulehandler.CheerUpStateRule;
import rpg.role.action.onepunchrulehandler.HighHpRule;
import rpg.role.action.onepunchrulehandler.NormalStateRule;

public class OnePunchSkill extends Action {

  private static final String NAME = "一拳攻擊";

  private static final int MP_COST = 180;

  private static final int STR = 0;

  private static final int TARGET_COUNT = 1;

  public OnePunchSkill() {
    super(NAME, MP_COST, 0, TARGET_COUNT);
  }

  @Override
  public void effect(Role target, Role self) {
    new HighHpRule(new AbnormalStateRule(new CheerUpStateRule(new NormalStateRule(null))))
        .handle(target, self);
  }
}
