package rpg.role.action;

public class SelfHealingSkill implements Action {
    public void handle() {
        System.out.println("Self healing!");
    }
}
