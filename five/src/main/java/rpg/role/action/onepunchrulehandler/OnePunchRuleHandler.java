package rpg.role.action.onepunchrulehandler;

import rpg.role.Role;

public abstract class OnePunchRuleHandler {

	protected OnePunchRuleHandler next;

	public OnePunchRuleHandler(OnePunchRuleHandler next) {
		this.next = next;
	}

	public abstract void handle(Role target, Role self);
}
