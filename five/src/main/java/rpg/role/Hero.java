package rpg.role;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import rpg.role.action.Action;
import rpg.troop.Troop;

public class Hero extends Role {
	private Scanner scanner;

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public Hero(String input, Troop troop) {
		super(input, troop);
	}

	public Action selectAction() {
		System.out.print("選擇行動：");

		for (int i = 0; i < getActionsSize(); i++) {
			System.out.printf("(%d) %s ", i, getActionName(i));
		}

		int choice = scanner.nextInt();
		scanner.nextLine();

		if (choice >= 0 && choice < getActionsSize()) {
			return getAction(choice);
		}

		return selectAction();
	}

	public List<Role> SelectTargets(Action action, List<Role> candidates) {
		int targetCount = action.getTargetCount();

		System.out.printf("選擇 %d 位目標：", targetCount);

		for (int i = 0; i < candidates.size(); i++) {
			Role role = candidates.get(i);
			System.out.printf("(%d) %s", i, role.getName());
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
