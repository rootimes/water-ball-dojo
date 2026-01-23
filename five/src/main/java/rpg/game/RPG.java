package rpg.game;

import java.util.List;
import java.util.Scanner;

import rpg.troop.Troop;
import rpg.role.Role;
import rpg.role.action.Action;
import rpg.role.action.Action;
import rpg.role.AI;
import rpg.role.Hero;

public class RPG {

    private Troop T1 = new Troop();
    private Troop T2 = new Troop();

    private List<Troop> troops = List.of(T1, T2);

    Scanner scanner = new Scanner(System.in);

    public void start() {

        setup();

        for (Troop troop : troops) {
            for (int i = 0; i < troop.size(); i++) {
                if (isGameOver()) {
                    break;
                }

                Role role = troop.get(i);

                if (!role.isAlive() || !role.canMove()) {
                    continue;
                }

                Action action = S1(role);

                List<Role> targets = S2(action, role);

                s3(targets, role);
            }
        }

    }

    public void end() {
        System.out.println("Game ended.");
    }

    private Action S1(Role role) {
        Action action = role.selectAction();

        while (!role.hasEnoughMP(action.getMp())) {
            action = role.selectAction();
        }
        return action;
    }

    private List<Role> S2(Action action, Role role) {
        return role.selectTargets(action, troops);
    }

    private void s3(List<Role> targets, Role role) {
        role.takeAction(targets);
    }

    private boolean isGameOver() {
        Role hero = T1.get(0);
        if (hero.isAlive()) {
            return T2.isEmpty();
        }

        return false;
    }

    private void setup() {
        String input = skipComments();
        Hero hero = new Hero(input, T1);
        T1.add(hero);

        readTroopMembers(T1);
        skipComments();
        readTroopMembers(T2);
    }

    private String skipComments() {
        String input = scanner.nextLine();
        while (input.contains("#")) {
            input = scanner.nextLine();
        }
        return input;
    }

    private void readTroopMembers(Troop troop) {
        String input = scanner.nextLine();
        while (!input.contains("結束")) {
            input = scanner.nextLine();
            AI ai = new AI(input, troop);
            troop.add(ai);
        }
    }
}
