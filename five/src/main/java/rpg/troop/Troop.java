package rpg.troop;

import java.util.ArrayList;
import java.util.List;

import rpg.role.Role;

public class Troop {
    private List<Role> roles = new ArrayList<>();

    public void add(Role role) {
        roles.add(role);
    }

    public int size() {
        return roles.size();
    }

    public boolean isEmpty() {
        return roles.isEmpty();
    }

    public Role get(int index) {
        return roles.get(index);
    }

    public List<Role> getAliveRoles() {
        List<Role> aliveRoles = new ArrayList<>();
        for (Role role : roles) {
            if (role.isAlive()) {
                aliveRoles.add(role);
            }
        }
        return aliveRoles;
    }
}
