package rpg.role.action;

import java.util.List;
import java.util.StringJoiner;

import rpg.role.Role;
import rpg.troop.Troop;

public abstract class Action implements ActionInterface {
  protected int mp;

  protected int str;

  protected String name;

  protected int targetCount;

  public Action(String name, int mp, int str, int targetCount) {
    this.name = name;
    this.mp = mp;
    this.str = str;
    this.targetCount = targetCount;
  }

  public List<Role> getCandidates(List<Troop> troops, Role self) {
    Troop ownTroop = self.getTroop();

    Troop enemyTroop = troops.stream().filter(troop -> troop != ownTroop).findFirst().orElse(null);

    List<Role> enemies = enemyTroop.getAliveRoles();

    return enemies;
  }

  @Override
  public void handle(List<Role> targets, Role self) {
    printActionInfo(targets, self);
    for (Role target : targets) {
      effect(target, self);
    }
  }

  public String getName() {
    return name;
  }

  public int getTargetCount() {
    return targetCount;
  }

  public int getMp() {
    return mp;
  }

  protected void printActionInfo(List<Role> targets, Role self) {
    StringBuilder sb = new StringBuilder();
    StringJoiner joiner = new StringJoiner(", ");
    for (Role target : targets) {
      joiner.add(String.format("[%d]%s", target.getTroopNumber(), target.getName()));
    }
    sb.append(joiner.toString());

    if (targets.isEmpty()) {
      System.out.printf("[%d]%s 使用了 %s。\n", self.getTroopNumber(), self.getName(), this.getName());
    } else {
      System.out.printf(
          "[%d]%s 對 %s 使用了 %s。\n",
          self.getTroopNumber(), self.getName(), sb.toString(), this.getName());
    }
  }

  protected void effect(Role target, Role self) {
    int damage = self.adjustDamage(this.str);

    System.out.printf(
        "[%d]%s 對 [%d]%s 造成 %d 點傷害。\n",
        self.getTroopNumber(), self.getName(), target.getTroopNumber(), target.getName(), damage);

    target.takeDamage(damage);
  }
}
