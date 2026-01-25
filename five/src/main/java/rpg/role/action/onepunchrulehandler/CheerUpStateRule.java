package rpg.role.action.onepunchrulehandler;

import rpg.role.Role;
import rpg.role.state.NormalState;

public class CheerUpStateRule extends OnePunchRuleHandler {

	private static final int STR = 100;

	public CheerUpStateRule(OnePunchRuleHandler next) {
		super(next);
	}

	@Override
	protected void effect(Role target, Role self) {
		int damage = self.adjustDamage(STR);
		target.takeDamage(damage);
		printDamage(target, self, damage);
		target.enterState(new NormalState());
		printDie(target, self);
	}

	@Override
	protected boolean shouldApply(Role target, Role self) {
		return target.getStateClassName().equals("CheerUpState");
	}
}
