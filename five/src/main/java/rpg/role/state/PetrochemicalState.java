package rpg.role.state;

import rpg.role.Role;

public class PetrochemicalState extends State {

  private static final String NAME = "石化";

  private static final int ROUND = 3;

  public PetrochemicalState() {
    this.name = NAME;
    this.round = ROUND;
  }

  public void enter() {
    this.round = 3;
  }

  @Override
  public boolean canMove(Role self) {
    return false;
  }
}
