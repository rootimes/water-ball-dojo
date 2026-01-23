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
		return this.actionStrategy.handle(this.actions, this);
	}

	@Override
	public List<Role> SelectTargets(Action action, List<Role> candidates) {
		return this.targetStrategy.handle(action, candidates, this);
	}
}