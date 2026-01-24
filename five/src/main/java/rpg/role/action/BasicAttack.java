package rpg.role.action;

import java.util.List;
import rpg.role.Role;

public class BasicAttack extends Action {

	private static final String NAME = "普通攻擊";

	private static final int MP_COST = 0;

	private static final int TARGET_COUNT = 1;

	public BasicAttack(int str) {
		super(NAME, MP_COST, str, TARGET_COUNT);
	}

	@Override
	protected void printAttackInfo(List<Role> targets, Role self) {
		Role target = targets.get(0);

		System.out.printf("[%d]%s 攻擊 [%d]%s。\n", self.getTroopNumber(), self.getName(),
				target.getTroopNumber(), target.getName());
	}

}