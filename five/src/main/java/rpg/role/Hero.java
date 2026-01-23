package rpg.role;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import rpg.role.action.Action;
import rpg.troop.Troop;

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

	public List<Role> SelectTargets(Action action, List<Role> candidates) {
		int targetCount = action.getTargetCount();

		System.out.print("選擇" + targetCount + "位目標：");

		for (int i = 0; i < candidates.size(); i++) {
			System.out.print("(" + i + ") " + candidates.get(i).getName());
			if (i < candidates.size() - 1) {
				System.out.print(" ");
			}
		}

		String[] parts = scanner.nextLine().split(",");
		int[] choices = new int[parts.length];
		for (int i = 0; i < parts.length; i++) {
			choices[i] = Integer.parseInt(parts[i]);
		}

		if (choices.length != targetCount) {
			return SelectTargets(action, candidates);
		}

		List<Role> selectedTargets = new ArrayList<>();
		for (int choice : choices) {
			selectedTargets.add(candidates.get(choice));
		}

		return selectedTargets;
	}
}
