package rpg.role.state;

import rpg.role.Role;

public class PetrochemicalState extends State {

	private int round;

	public void enter() {
		this.round = 3;
	}

	@Override
	public boolean canMove(Role self) {
		return false;
	}
}
