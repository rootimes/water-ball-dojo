package rpg.role.observer;

import rpg.role.Role;

public class SummonObserver implements DeathObserver {

  private final Role summoner;

  private final int HEAL_AMOUNT = 30;

  public SummonObserver(Role summoner) {
    this.summoner = summoner;
  }

  @Override
  public void update(int value) {
    if (summoner.isAlive()) {
      summoner.heal(HEAL_AMOUNT);
    }
  }
}
