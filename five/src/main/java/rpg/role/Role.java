package rpg.role;

import rpg.role.state.State;
import rpg.role.action.Action;
import java.util.ArrayList;
import java.util.List;

public abstract class Role {

    protected int hp;

    protected int mp;

    protected State state;

    protected List<Action> actions = new ArrayList<>();

    public void takeDamage(int damage) {
        this.hp -= damage;
    }

    public void enterState(State newState) {
        if (this.state != null) {
            this.state.exit();
        }
        this.state = newState;
        this.state.enter();
    }
}
