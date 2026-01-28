package rpg.troop;

import java.util.ArrayList;
import java.util.List;

import rpg.role.Role;

public class Troop {
	private List<Role> roles = new ArrayList<>();
	private int number;

	public void add(Role role) {
		roles.add(role);
	}

	public int size() {
		return roles.size();
	}

	public boolean isAnnihilated() {
		return getAliveRoles().isEmpty();
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

	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public Role get(int index) {
		return roles.get(index);
	}
}
