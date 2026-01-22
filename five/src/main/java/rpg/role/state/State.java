package rpg.role.state;

import org.jetbrains.annotations.Nullable;

import rpg.role.Role;

public abstract class State {

    @Nullable
    protected Integer round;

    public void enter(int round) {
        this.round = round;
    };

    public void exit() {
        this.round = null;
    };

    public void onTurnStart(Role attacker) {
    };

    public boolean canMove(Role attacker) {
        return true;
    };

    public int adjustDamage(Role attacker, int damage) {
        return damage;
    }
}