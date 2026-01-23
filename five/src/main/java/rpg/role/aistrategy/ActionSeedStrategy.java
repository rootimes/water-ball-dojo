package rpg.role.aistrategy;

import java.util.List;

import rpg.role.AI;
import rpg.role.action.Action;

public class ActionSeedStrategy implements AIActionStrategy {
	@Override
	public Action handle(List<Action> actions, AI role) {
		int seed = role.getSeed();

		Action action = actions.get(seed % actions.size());

		if (role.hasEnoughMP(action.getMp())) {
			role.increaseSeed();
			return action;
		} else {
			role.increaseSeed();
			return handle(actions, role);
		}
	}
}
