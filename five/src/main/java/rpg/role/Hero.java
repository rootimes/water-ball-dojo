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

	@Override
	public Action selectAction() {
		System.out.print("選擇行動：");
		for (int i = 0; i < getActionsSize(); i++) {
			System.out.printf("(%d) %s", i, getActionName(i));
			if (i < getActionsSize() - 1)
				System.out.print(" ");
		}
		System.out.println();

		if (!scanner.hasNextLine()) {
			throw new IllegalStateException("沒有更多輸入可讀（測試 .in 不足）");
		}

		int choice = scanner.nextInt();
		scanner.nextLine();

		if (choice >= 0 && choice < getActionsSize()) {
			return getAction(choice);
		}

		System.out.println("輸入超出範圍，請重新選擇行動。");

		return selectAction();
	}

	@Override
	public List<Role> selectTargets(Action action, List<Role> candidates) {
		int targetCount = action.getTargetCount();

		System.out.printf("選擇 %d 位目標: ", targetCount);

		for (int i = 0; i < candidates.size(); i++) {
			Role role = candidates.get(i);
			System.out.printf("(%d) [%d]%s", i, role.getTroopNumber(), role.getName());
			if (i < candidates.size() - 1) {
				System.out.print(" ");
			}
		}

		System.out.println();

		String[] parts = scanner.nextLine().split(",");
		int[] choices = new int[parts.length];
		for (int i = 0; i < parts.length; i++) {
			choices[i] = Integer.parseInt(parts[i].trim());
		}

		if (choices.length != targetCount) {
			return selectTargets(action, candidates);
		}

		List<Role> selectedTargets = new ArrayList<>();
		for (int choice : choices) {
			selectedTargets.add(candidates.get(choice));
		}

		return selectedTargets;
	}
}
