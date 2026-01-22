package rpg.role.observer;

import rpg.role.Role;

public class CurseObserver implements DeathObserver {
    
    private final Role caster;
    
    public CurseObserver(Role caster) {
        this.caster = caster;
    }

    @Override
    public void update() {
        System.out.println("A curse has been lifted upon the death of the role.");
    }
    
}
