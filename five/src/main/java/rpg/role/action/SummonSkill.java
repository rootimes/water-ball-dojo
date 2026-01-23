package rpg.role.action;

import java.util.List;

import rpg.role.AI;
import rpg.role.Role;
import rpg.role.observer.SummonObserver;
import rpg.role.state.NormalState;
import rpg.troop.Troop;

public class SummonSkill extends Action {

	private static final String NAME = "召喚";

	private static final int MP_COST = 150;

	private static final int STR = 0;

	private static final int TARGET_COUNT = 0;

	public SummonSkill() {
		super(NAME, MP_COST, STR, TARGET_COUNT);
	}

	@Override
	public List<Role> getCandidates(List<Troop> troops, Role self) {
		return List.of();
	}

	@Override
	public void handle(List<Role> targets, Role self) {
		effect(self, self);
	}

	@Override
	protected void effect(Role target, Role self) {
		Troop troop = self.getTroop();

		Role slime = new AI("Slime 100  0 50", troop);

		slime.enterState(new NormalState());

		slime.registerDeathObserver(new SummonObserver(self), self);

		troop.add(slime);
	}
}
