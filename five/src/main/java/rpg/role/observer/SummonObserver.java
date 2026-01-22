package rpg.role.observer;

import rpg.role.Role;

public class SummonObserver implements DeathObserver {

    private final Role summoner;

    public SummonObserver(Role summoner) {
        this.summoner = summoner;
    }

    @Override
    public void update() {
        System.out.println("A summoned creature vanishes upon the death of the role.");
    }

}
