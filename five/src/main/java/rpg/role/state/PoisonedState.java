package rpg.role.state;

import rpg.role.Role;

public class PoisonedState extends State {

    private static final int DAMAGE_PER_TURN = 30;

    private int round;

    public void enter() {
        this.round = 3;
    }

    @Override
    public void onTurnStart(Role self) {
        self.takeDamage(DAMAGE_PER_TURN);
    }
}
