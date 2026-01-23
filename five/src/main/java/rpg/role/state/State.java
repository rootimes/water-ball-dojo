package rpg.role.state;

import rpg.role.Role;

public abstract class State {
	protected int round;

	public String getName() {
		return this.getClass().getSimpleName();
	}

	public void enter() {
		this.round = 0;
	};

	public void exit() {
		this.round = 0;
	};

	public void onTurnStart(Role self) {
	};

	public boolean canMove(Role self) {
		return true;
	};

	public int adjustDamage(int damage) {
		return damage;
	}

	public void onTurnEnd(Role self) {
		if (this.round > 0) {
			this.round--;
			if (this.round == 0) {
				self.enterState(new NormalState());
			}
		}
	}
}