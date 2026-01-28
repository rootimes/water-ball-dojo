package rpg.role.aistrategy;

import java.util.ArrayList;
import java.util.List;

import rpg.role.AI;
import rpg.role.Role;
import rpg.role.action.Action;

public class TargetSeedStrategy implements AITargetStrategy {
	@Override
	public List<Role> handle(Action action, List<Role> candidates, AI role) {
		int seed = role.getSeed();
		int targetCount = action.getTargetCount();
		int n = candidates.size();

		List<Role> targets = new ArrayList<>(targetCount);

		for (int i = 0; i < targetCount; i++) {
			int index = (seed + i) % n;
			targets.add(candidates.get(index));
		}

		role.increaseSeed();

		return targets;
	}
}
