package rpg.role.action.onepunchrulehandler;

import rpg.role.Role;

public class NormalStateRule extends OnePunchRuleHandler {

  private static final int STR = 100;

  public NormalStateRule(OnePunchRuleHandler next) {
    super(next);
  }

  @Override
  protected void effect(Role target, Role self) {
    int damage = self.adjustDamage(STR);
    printDamage(target, self, damage);
    target.takeDamage(damage);
  }

  @Override
  protected boolean shouldApply(Role target, Role self) {
    return target.getStateClassName().equals("NormalState");
  }
}
