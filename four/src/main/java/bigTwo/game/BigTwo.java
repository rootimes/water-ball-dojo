package bigTwo.game;

import java.util.ArrayList;
import java.util.List;

import bigTwo.card.Card;
import bigTwo.card.Deck;
import bigTwo.cardhandler.CardHandler;
import bigTwo.cardhandler.FullHouseHandler;
import bigTwo.cardhandler.PairHandler;
import bigTwo.cardhandler.SingleHandler;
import bigTwo.cardhandler.StraightHandler;
import bigTwo.cardpattern.CardPattern;
import bigTwo.player.Human;
import bigTwo.player.Player;
import java.util.Scanner;

public class BigTwo {

	private Deck deck;

	private List<Player> players = new ArrayList<>();

	private Player topPlayer;

	private CardPattern<?> topPlay;

	private Player winner;

	Scanner scanner = new Scanner(System.in);

	// 互動模式：手動輸入名字，自動洗牌
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

	// 測試模式：從輸入讀取牌堆
	public BigTwo(boolean testMode) {
		String deckInput = scanner.nextLine();
		deck = new Deck(deckInput);

		for (int i = 0; i < 4; i++) {
			Player human = new Human();

			String name = scanner.nextLine();

			human.name(name);
			players.add(human);
		}

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

		// 第一輪讓其他玩家也打牌
		int index = players.indexOf(topPlayer);
		for (int i = 1; i < players.size(); i++) {
			index = (index + 1) % players.size();
			Player player = players.get(index);

			System.out.println("輪到" + player.getName() + "了");
			System.out.println(player.showHandCardIndexes());
			System.out.println(player.showHandCards());

			playRound(handler, player);

			if (player.getHandCardSize() == 0) {
				winner = player;
				return;
			}
		}

		// 後續回合
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

		// 發完牌後排序每個玩家的手牌
		for (Player player : players) {
			player.sortHandCards();
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
			System.out.println("玩家 " + player.getName() + " PASS.");
			return null;
		} else if (input.equals("-1") && topPlayer == player) {
			System.out.println("你不能在新的回合中喊 PASS");
			System.out.println(player.showHandCardIndexes());
			System.out.println(player.showHandCards());
			return firstRound(handler, player);
		}

		List<Card> playedCards = player.play(input);
		CardPattern<?> pattern = handler.handle(playedCards);

		if (isValidPlayForFirstRound(pattern)) {
			player.removeCards(playedCards);
			System.out.println("玩家 " + player.getName() + " 打出了 " + pattern.toString());
			topPlay = pattern;
			topPlayer = player;
			return pattern;
		} else {
			System.out.println("此牌型不合法，請再嘗試一次。");
			System.out.println(player.showHandCardIndexes());
			System.out.println(player.showHandCards());
			return firstRound(handler, player);
		}
	}

	private CardPattern<?> playRound(CardHandler<?> handler, Player player) {
		String input = scanner.nextLine().trim();

		if (input.equals("-1") && topPlayer != player) {
			System.out.println("玩家 " + player.getName() + " PASS.");
			return null;
		} else if (input.equals("-1") && topPlayer == player) {
			System.out.println("你不能在新的回合中喊 PASS");
			System.out.println(player.showHandCardIndexes());
			System.out.println(player.showHandCards());
			return playRound(handler, player);
		}

		List<Card> playedCards = player.play(input);
		CardPattern<?> pattern = handler.handle(playedCards);

		if (isValidPlay(pattern)) {
			player.removeCards(playedCards);
			System.out.println("玩家 " + player.getName() + " 打出了 " + pattern.toString());
			topPlay = pattern;
			topPlayer = player;
			return pattern;
		} else {
			System.out.println("此牌型不合法，請再嘗試一次。");
			System.out.println(player.showHandCardIndexes());
			System.out.println(player.showHandCards());
			return playRound(handler, player);
		}
	}

	private boolean isValidPlayForFirstRound(CardPattern<?> pattern) {
		if (pattern == null) {
			return false;
		}

		if (pattern.getCards().stream().noneMatch(card -> card.isClub3())) {
			return false;
		}

		return true;
	}

	private boolean isValidPlay(CardPattern<?> pattern) {
		if (pattern == null) {
			return false;
		}

		if (topPlay == null) {
			return true;
		}

		if (!pattern.getClass().equals(topPlay.getClass())) {
			return false;
		}

		return pattern.compareTo(topPlay) > 0;
	}
}
