package rpg.game;

import java.util.List;
import java.util.Scanner;

import rpg.role.AI;
import rpg.role.Hero;
import rpg.role.Role;
import rpg.role.action.Action;
import rpg.role.aistrategy.ActionSeedStrategy;
import rpg.role.aistrategy.TargetSeedStrategy;
import rpg.troop.Troop;

public class RPG {

	private Troop T1 = new Troop();
	private Troop T2 = new Troop();

	private List<Troop> troops = List.of(T1, T2);

	Scanner scanner = new Scanner(System.in);

	private boolean win = false;

	public void start() {

		setup();

		for (Troop troop : troops) {
			for (int i = 0; i < troop.size(); i++) {
				if (isGameOver()) {
					return;
				}

				Role role = troop.get(i);

				if (!role.isAlive()) {
					continue;
				}

				if (role.canMove()) {
					role.onTurnStart();

					Action action = S1(role);

					List<Role> targets = S2(action, role);

					s3(action, targets, role);

					role.onTurnEnd();
				}
			}
		}
	}

	public void end() {
		if (win) {
			System.out.println("你獲勝了！");
		} else {
			System.out.println("你失敗了！");
		}
	}

	private Action S1(Role role) {
		Action action = role.selectAction();

		while (!role.hasEnoughMP(action.getMp())) {
			action = role.selectAction();
		}
		return action;
	}

	private List<Role> S2(Action action, Role role) {
		List<Role> candidates = action.getCandidates(troops, role);

		int actionTargetCount = action.getTargetCount();

		if (exceedsAvailableCandidates(candidates, actionTargetCount)) {
			return candidates;
		} else if (actionTargetCount == 0) {
			return List.of();
		}

		return role.SelectTargets(action, candidates);
	}

	private void s3(Action action, List<Role> targets, Role role) {
		role.takeAction(action, targets);
	}

	private boolean isGameOver() {
		Role hero = T1.get(0);
		if (hero.isAlive() && T2.isEmpty()) {
			this.win = true;
			return true;
		} else if (!hero.isAlive()) {
			this.win = false;
			return true;
		}

		return false;
	}

	private boolean exceedsAvailableCandidates(List<Role> candidates, int targetCount) {
		if (targetCount > candidates.size()) {
			return true;
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
			AI ai = new AI(input, troop);
			ai.setAIStrategies(new ActionSeedStrategy(), new TargetSeedStrategy());
			troop.add(ai);
			input = scanner.nextLine();
		}
	}
}
