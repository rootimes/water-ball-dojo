package rpg.role.aistrategy;

import java.util.List;

import rpg.role.AI;
import rpg.role.action.Action;

public interface AIActionStrategy {
	public abstract Action handle(List<Action> actions, AI role);
}
