package rpg.role.action;

import java.util.List;

import rpg.role.Role;
import rpg.troop.Troop;

public interface ActionInterface {

	void handle(List<Role> targets, Role self);

	int getMp();

	List<Role> getCandidates(List<Troop> troops, Role self);
}
