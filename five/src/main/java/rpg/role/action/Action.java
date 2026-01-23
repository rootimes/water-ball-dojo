package rpg.role.action;

import java.util.List;

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

	public String getName() {
		return name;
	}

	public int getTargetCount() {
		return targetCount;
	}

	public List<Role> getCandidates(List<Troop> troops, Role self) {
		Troop ownTroop = self.getTroop();

		Troop enemyTroop = troops.stream().filter(troop -> troop != ownTroop).findFirst().orElse(null);

		List<Role> enemies = enemyTroop.getAliveRoles();

		return enemies;
	}

	@Override
	public void handle(List<Role> targets, Role self) {
		for (Role target : targets) {
			effect(target, self);
		}
	}

	public int getMp() {
		return mp;
	};

	protected abstract void effect(Role target, Role self);
}
