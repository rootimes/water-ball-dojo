package rpg.role.action;

import java.util.ArrayList;
import java.util.List;

import rpg.role.Role;
import rpg.troop.Troop;

public class SelfExplosionSkill extends Action {

	private static final String NAME = "自爆";

	private static final int MP_COST = 0;

	private static final int STR = 150;

	private static final int TARGET_COUNT = Integer.MAX_VALUE;

	@Override
	public List<Role> getCandidates(List<Troop> troops, Role self) {

		List<Role> roles = new ArrayList<>();

		for (Troop troop : troops) {
			roles.addAll(troop.getAliveRoles());
			roles.remove(self);
		}

		return roles;
	}

	public SelfExplosionSkill() {
		super(NAME, MP_COST, STR, TARGET_COUNT);
	}

	@Override
	public void handle(List<Role> targets, Role self) {
		printActionInfo(targets, self);
		for (Role target : targets) {
			effect(target, self);
		}

		self.die();
	}
}
