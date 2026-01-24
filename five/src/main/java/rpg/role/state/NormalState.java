package rpg.role.state;

import rpg.role.Role;

public class NormalState extends State {

	private static final String NAME = "正常";

	private static final int ROUND = 0;

	public NormalState() {
		this.name = NAME;
		this.round = ROUND;
	}

	@Override
	public void onTurnEnd(Role self) {
	}
}