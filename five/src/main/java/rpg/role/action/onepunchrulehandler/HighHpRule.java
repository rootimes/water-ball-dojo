package rpg.role.action.onepunchrulehandler;

import rpg.role.Role;

public class HighHpRule extends OnePunchRuleHandler {

	private static final int STR = 300;

	public HighHpRule(OnePunchRuleHandler next) {
		super(next);
	}

	@Override
	protected boolean shouldApply(Role target, Role self) {
		return target.getHp() > 500;
	}

	@Override
	protected void effect(Role target, Role self) {
		int damage = self.adjustDamage(STR);
		printDamage(target, self, damage);
		target.takeDamage(damage);
	}
}
