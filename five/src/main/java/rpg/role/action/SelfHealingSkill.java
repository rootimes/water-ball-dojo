package rpg.role.action;

import java.util.List;

import rpg.role.Role;
import rpg.troop.Troop;

public class SelfHealingSkill extends Action {

	private static final String NAME = "自我治療";

	private static final int MP_COST = 50;

	private static final int STR = 150;

	private static final int TARGET_COUNT = 0;

	public SelfHealingSkill() {
		super(NAME, MP_COST, STR, TARGET_COUNT);
	}

	@Override
	public List<Role> getCandidates(List<Troop> troops, Role self) {
		return List.of(self);
	}

	@Override
	public void handle(List<Role> targets, Role self) {
		effect(self, self);
	}

	@Override
	protected void printAttackInfo(List<Role> targets, Role self) {
		System.out.printf("[%d]%s 使用了 %s。\n", self.getTroopNumber(), self.getName(),
				this.getName());
	}

	@Override
	protected void effect(Role target, Role self) {
		self.heal(str);
	}
}
