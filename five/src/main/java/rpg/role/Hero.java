package rpg.role;

import rpg.role.action.Action;
import rpg.troop.Troop;
import java.util.List;
import java.util.Scanner;

public class Hero extends Role {
    private Scanner scanner = new Scanner(System.in);

    public Hero(String input, Troop troop) {
        super(input, troop);
    }

    public Action selectAction() {
        System.out.print("選擇行動：");

        for (int i = 0; i < getActionsSize(); i++) {
            System.out.print("(" + i + ") " + getAction(i).getName());
            if (i < getActionsSize() - 1) {
                System.out.print(" ");
            }
        }

        int choice = scanner.nextInt();

        if (choice >= 0 && choice < getActionsSize()) {
            return getAction(choice);
        }

        return selectAction();
    }

    public List<Role> selectTargets(Action action, List<Troop> troops) {
        // Implementation for hero target selection
        return null;
    }
}
