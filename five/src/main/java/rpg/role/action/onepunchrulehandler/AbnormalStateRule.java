package rpg.role.action.onepunchrulehandler;

import java.util.List;

import rpg.role.Role;

public class AbnormalStateRule extends OnePunchRuleHandler {

	private static final int STR = 80;

	public AbnormalStateRule(OnePunchRuleHandler next) {
		super(next);
	}

	@Override
	protected void effect(Role target, Role self) {
		for (int i = 0; i < 3; i++) {
			int damage = self.adjustDamage(STR);
			target.takeDamage(damage);
			printDamage(target, self, damage);
			printDie(target, self);

			if (!target.isAlive()) {
				break;
			}
		}
	}

	@Override
	protected boolean shouldApply(Role target, Role self) {
		List<String> abnormalStates = List.of("PoisonedState", "PetrochemicalState");
		return abnormalStates.contains(target.getStateClassName());
	}
}
