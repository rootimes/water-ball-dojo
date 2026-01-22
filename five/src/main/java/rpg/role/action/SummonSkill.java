package rpg.role.action;

import java.util.List;

import rpg.role.AI;
import rpg.role.Role;
import rpg.role.observer.SummonObserver;
import rpg.role.state.NormalState;
import rpg.troop.Troop;

public class SummonSkill extends Action {

    public SummonSkill() {
        super(150, 0);
    }

    @Override
    public void handle(List<Role> targets, Role self) {
        self.consumeMp(mp);
        effect(self);
    }

    @Override
    protected void effect(Role self) {
        Troop troop = self.getTroop();

        Role slime = new AI("Slime 100  0 50", troop);

        slime.enterState(new NormalState());

        slime.registerDeathObserver(new SummonObserver(self), self);

        troop.add(slime);
    }
}
