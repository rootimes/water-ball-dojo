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

	public RPG() {
		T1.setNumber(1);
		T2.setNumber(2);
	}

	public void start() {

		setup();

		while (!isGameOver()) {
			for (Troop troop : troops) {
				for (int i = 0; i < troop.size(); i++) {
					if (isGameOver()) {
						return;
					}

					Role role = troop.get(i);

					if (!role.isAlive()) {
						continue;
					}

					System.out.printf("輪到 [%d]%s (HP: %d, MP: %d, STR: %d, State: %s)。\n", role.getTroopNumber(),
							role.getName(), role.getHp(), role.getMp(), role.getStr(), role.getStateName());
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

		if (role instanceof Hero) {
			while (!role.hasEnoughMP(action.getMp())) {
				System.out.println("MP 不足，請重新選擇行動。");
				action = role.selectAction();
			}
		}

		return action;
	}

	private List<Role> S2(Action action, Role role) {
		List<Role> candidates = action.getCandidates(troops, role);

		int targetCount = action.getTargetCount();

		if (targetCount >= candidates.size()) {
			return candidates;
		} else if (targetCount == 0) {
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

	private void setup() {
		moveToSectionStart("軍隊-1");

		String heroLine = nextNonCommentNonBlankLine();
		Hero hero = new Hero(heroLine, T1);
		hero.setScanner(this.scanner);
		T1.add(hero);

		readTroopMembersUntilEnd(T1, "軍隊-1");

		moveToSectionStart("軍隊-2");
		readTroopMembersUntilEnd(T2, "軍隊-2");
	}

	private void moveToSectionStart(String troopTag) {
		String line = scanner.nextLine();
		while (!(line.startsWith("#") && line.contains(troopTag) && line.contains("開始"))) {
			line = scanner.nextLine();
		}
	}

	private String nextNonCommentNonBlankLine() {
		String line = scanner.nextLine();
		while (line.isBlank() || line.startsWith("#")) {
			line = scanner.nextLine();
		}
		return line;
	}

	private void readTroopMembersUntilEnd(Troop troop, String troopTag) {
		String line = scanner.nextLine();

		while (true) {
			if (line.startsWith("#") && line.contains(troopTag) && line.contains("結束")) {
				break;
			}

			if (!line.isBlank() && !line.startsWith("#")) {
				AI ai = new AI(line, troop);
				ai.setAIStrategies(new ActionSeedStrategy(), new TargetSeedStrategy());
				troop.add(ai);
			}

			line = scanner.nextLine();
		}
	}
}
