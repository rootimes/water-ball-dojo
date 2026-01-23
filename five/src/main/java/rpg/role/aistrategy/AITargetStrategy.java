package rpg.role.aistrategy;

import java.util.List;

import rpg.role.AI;
import rpg.role.Role;
import rpg.role.action.Action;

public interface AITargetStrategy {
	public abstract List<Role> handle(Action action, List<Role> candidates, AI role);
}
