package rpg.role;

import java.util.List;

import rpg.role.action.Action;
import rpg.role.aistrategy.AIActionStrategy;
import rpg.role.aistrategy.AITargetStrategy;
import rpg.troop.Troop;

public class AI extends Role {

  private AIActionStrategy actionStrategy;

  private AITargetStrategy targetStrategy;

  private int seed = 0;

  public AI(String input, Troop troop) {
    super(input, troop);
  }

  public int getSeed() {
    return seed;
  }

  public int increaseSeed() {
    return ++seed;
  }

  public void setAIStrategies(AIActionStrategy actionStrategy, AITargetStrategy targetStrategy) {
    this.actionStrategy = actionStrategy;
    this.targetStrategy = targetStrategy;
  }

  @Override
  public Action selectAction() {
    System.out.print("選擇行動：");

    for (int i = 0; i < getActionsSize(); i++) {
      System.out.printf("(%d) %s", i, getActionName(i));
      if (i < getActionsSize() - 1) {
        System.out.print(" ");
      }
    }

    System.out.println();

    return this.actionStrategy.handle(this.actions, this);
  }

  @Override
  public List<Role> selectTargets(Action action, List<Role> candidates) {
    return this.targetStrategy.handle(action, candidates, this);
  }
}
