package rpg.role.action;

public class WaterBallSkill extends Action {

  private static final String NAME = "水球";

  private static final int MP_COST = 50;

  private static final int STR = 120;

  private static final int TARGET_COUNT = 1;

  public WaterBallSkill() {
    super(NAME, MP_COST, STR, TARGET_COUNT);
  }
}
