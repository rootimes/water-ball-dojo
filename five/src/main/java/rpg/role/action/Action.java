package rpg.role.action;

import java.util.List;

import rpg.role.Role;

public abstract class Action implements ActionInterface {

    protected static final String NAME = "未知技能";

    protected int mp;

    protected int str;

    public Action(int mp, int str) {
        this.mp = mp;
        this.str = str;
    }

    public String getName() {
        return NAME;
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
