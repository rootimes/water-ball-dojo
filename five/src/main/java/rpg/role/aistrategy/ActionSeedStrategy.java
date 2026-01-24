package rpg.role.aistrategy;

import java.util.List;

import rpg.role.AI;
import rpg.role.action.Action;

public class ActionSeedStrategy implements AIActionStrategy {
	@Override
	public Action handle(List<Action> actions, AI role) {
		Action action;
		do {
			int seed = role.getSeed();
			action = actions.get(seed % actions.size());
			role.increaseSeed();
		} while (!role.hasEnoughMP(action.getMp()));
		return action;
	}
}
