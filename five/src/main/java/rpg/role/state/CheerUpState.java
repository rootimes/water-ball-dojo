package rpg.role.state;

public class CheerUpState extends State {
  private static final int EXT_STR = 50;

  private static final String NAME = "受到鼓舞";

  private static final int ROUND = 3;

  public CheerUpState() {
    this.name = NAME;
    this.round = ROUND;
  }

  public void enter() {
    this.round = ROUND;
  }

  public int adjustDamage(int damage) {
    return damage + EXT_STR;
  }
}
