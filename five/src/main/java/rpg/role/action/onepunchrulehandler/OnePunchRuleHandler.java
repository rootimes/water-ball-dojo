package rpg.role.action.onepunchrulehandler;

import rpg.role.Role;

public abstract class OnePunchRuleHandler {

  protected OnePunchRuleHandler next;

  public OnePunchRuleHandler(OnePunchRuleHandler next) {
    this.next = next;
  }

  public void handle(Role target, Role self) {
    if (shouldApply(target, self)) {
      effect(target, self);
      return;
    }

    if (next != null) {
      next.handle(target, self);
    }
  }

  protected abstract boolean shouldApply(Role target, Role self);

  protected abstract void effect(Role target, Role self);

  protected void printDamage(Role target, Role self, int damage) {
    System.out.printf(
        "[%d]%s 對 [%d]%s 造成 %d 點傷害。\n",
        self.getTroopNumber(), self.getName(), target.getTroopNumber(), target.getName(), damage);
  }
}
