package rpg.role.action;

import rpg.role.Role;
import java.util.List;

public interface ActionInterface {

    public abstract void handle(List<Role> targets, Role self);

    public abstract int getMp();
}
