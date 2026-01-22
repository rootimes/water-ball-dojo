package rpg.role.action;

import java.util.List;

import rpg.role.Role;

public abstract class Action implements ActionInterface {

    protected int mp;

    protected int str;

    public Action(int mp, int str) {
        this.mp = mp;
        this.str = str;
    }

    @Override
    public void handle(List<Role> targets, Role self) {
        self.consumeMp(mp);
        for (Role target : targets) {
            effect(target);
        }
    }

    public int getMp() {
        return mp;
    };

    protected abstract void effect(Role target);
}
