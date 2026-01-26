package rpg.role.action;

import java.util.List;

import rpg.role.Role;
import rpg.troop.Troop;

public class FireBallSkill extends Action {

	private static final String NAME = "火球";

	private static final int MP_COST = 50;

	private static final int STR = 50;

	private static final int TARGET_COUNT = Integer.MAX_VALUE;

	public FireBallSkill() {
		super(NAME, MP_COST, STR, TARGET_COUNT);
	}
}
