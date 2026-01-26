package rpg.role.aistrategy;

import java.util.List;

import rpg.role.AI;
import rpg.role.action.Action;

public class ActionSeedStrategy implements AIActionStrategy {
  @Override
  public Action handle(List<Action> actions, AI role) {
    Action action;
    int seed = role.getSeed();
    action = actions.get(seed % actions.size());
    role.increaseSeed();
    return action;
  }
}
