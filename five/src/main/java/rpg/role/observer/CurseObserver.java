package rpg.role.observer;

import rpg.role.Role;

public class CurseObserver implements DeathObserver {

	private final Role caster;

	public CurseObserver(Role caster) {
		this.caster = caster;
	}

	@Override
	public void update(int effect) {
		if (caster.isAlive()) {
			caster.heal(effect);
		}
	}
}
