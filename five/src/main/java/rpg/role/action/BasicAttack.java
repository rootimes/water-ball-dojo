package rpg.role.action;

import rpg.role.Role;

public class BasicAttack extends Action {

	private static final String NAME = "普通攻擊";

	private static final int MP_COST = 0;

	private static final int TARGET_COUNT = 1;

	public BasicAttack(int str) {
		super(NAME, MP_COST, str, TARGET_COUNT);
	}

	@Override
	protected int effect(Role target, Role self) {
		int damage = self.adjustDamage(this.str);
		target.takeDamage(damage);
		return damage;
	}
}