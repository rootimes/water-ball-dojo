package rpg.role.state;

public class CheerUpState extends State {
	private static final int EXT_STR = 50;

	private int round;

	public void enter() {
		this.round = 3;
	}

	public int adjustDamage(int damage) {
		return damage + EXT_STR;
	}
}
