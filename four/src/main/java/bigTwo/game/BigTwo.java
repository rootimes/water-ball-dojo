package bigTwo.game;

import java.util.ArrayList;
import java.util.List;

import bigTwo.Card.Deck;
import bigTwo.CardHandler.CardHandler;
import bigTwo.CardHandler.FullHouseHandler;
import bigTwo.CardHandler.PairHandler;
import bigTwo.CardHandler.SingleHandler;
import bigTwo.CardHandler.StraightHandler;
import bigTwo.CardPattern.CardPattern;
import bigTwo.player.Human;
import bigTwo.player.Player;
import java.util.Scanner;
import bigTwo.Card.Card;

public class BigTwo {

	private Deck deck;

	private List<Player> players = new ArrayList<>();

	private Player topPlayer;

	private CardPattern<?> topPlay;

	private Player winner;

	Scanner scanner = new Scanner(System.in);

	// 題目無描述電腦玩家，暫不加入
	public BigTwo() {
		for (int i = 0; i < 4; i++) {
			Player human = new Human();

			System.out.print("請輸入玩家 " + i + " 的名字: ");
			String name = scanner.nextLine();

			human.name(name);
			players.add(human);
		}

		deck = new Deck();

		deck.shuffle();

		dealCards();
	}

	public void start() {
		System.out.println("新的回合開始了。");

		topPlayer = getPlayerHasClub3();

		System.out.println("輪到" + topPlayer.getName() + "了");

		CardHandler<?> handler = new SingleHandler(new PairHandler(new StraightHandler(new FullHouseHandler(null))));

		System.out.println(topPlayer.showHandCardIndexes());
		System.out.println(topPlayer.showHandCards());

		firstRound(handler, topPlayer);

		int index = players.indexOf(topPlayer);
		while (winner == null) {
			index = (index + 1) % players.size();
			Player player = players.get(index);

			if (player == topPlayer) {
				topPlay = null;
				System.out.println("新的回合開始了。");
			}

			System.out.println("輪到" + player.getName() + "了");

			System.out.println(player.showHandCardIndexes());
			System.out.println(player.showHandCards());

			playRound(handler, player);

			if (player.getHandCardSize() == 0) {
				winner = player;
			}
		}
	}

	public void end() {
		System.out.println("遊戲結束，遊戲的勝利者為 " + winner.getName());
	}

	private void dealCards() {
		int i = 0;
		while (deck.hasCards()) {
			Player player = players.get(i);
			Card card = deck.deal();
			player.addCard(card);
			i = (i + 1) % players.size();
		}
	}

	private Player getPlayerHasClub3() {
		for (Player player : players) {
			for (int i = 0; i < 13; i++) {
				Card card = player.getHandCard(i);
				if (card.isClub3()) {
					return player;
				}
			}
		}
		return null;
	}

	// TODO: 重構這兩個方法，合併重複程式碼，樣板方法? 策略模式?
	private CardPattern<?> firstRound(CardHandler<?> handler, Player player) {
		String input = scanner.nextLine().trim();

		if (input.equals("-1") && topPlayer != player) {
			System.out.println("玩家 " + player.getName() + " PASS");
			return null;
		} else if (input.equals("-1") && topPlayer == player) {
			System.out.println("你不能在新的回合中喊 PASS");
			return firstRound(handler, player);
		}

		List<Card> playedCards = topPlayer.play(input);
		CardPattern<?> pattern = handler.handle(playedCards);

		if (isValidPlayForFirstRound(pattern)) {
			System.out.println("玩家 " + player.getName() + " 打出了 " + pattern.toString());
			topPlay = pattern;
			topPlayer = player;
			return pattern;
		} else {
			System.out.println("此牌型不合法，請再嘗試一次。");
			return firstRound(handler, player);
		}
	}

	private CardPattern<?> playRound(CardHandler<?> handler, Player player) {
		String input = scanner.nextLine().trim();

		if (input.equals("-1") && topPlayer != player) {
			System.out.println("玩家 " + player.getName() + " PASS");
			return null;
		} else if (input.equals("-1") && topPlayer == player) {
			System.out.println("你不能在新的回合中喊 PASS");
			return playRound(handler, player);
		}

		List<Card> playedCards = player.play(input);
		CardPattern<?> pattern = handler.handle(playedCards);

		if (isValidPlay(pattern)) {
			System.out.println("玩家 " + player.getName() + " 打出了 " + pattern.toString());
			topPlay = pattern;
			topPlayer = player;
			return pattern;
		} else {
			System.out.println("此牌型不合法，請再嘗試一次。");
			return playRound(handler, player);
		}
	}

	private boolean isValidPlayForFirstRound(CardPattern<?> pattern) {
		if (pattern.getCards().stream().noneMatch(card -> card.isClub3())) {
			return false;
		}

		return true;
	}

	private boolean isValidPlay(CardPattern<?> pattern) {
		if (topPlay == null) {
			return true;
		}

		if (!pattern.getClass().equals(topPlay.getClass())) {
			return false;
		}

		return pattern.compareTo(topPlay) > 0;
	}
}
