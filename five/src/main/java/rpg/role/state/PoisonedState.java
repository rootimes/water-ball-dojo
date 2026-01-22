package rpg.role.state;

public class PoisonedState extends State {
    @Override
    public void onTurnStart(rpg.role.Role attacker) {
        attacker.takeDamage(5);
    }
}
