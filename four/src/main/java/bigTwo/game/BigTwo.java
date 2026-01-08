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

public class BigTwo  {

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

		Player topPlayer = getPlayerHasClub3();

		System.out.println("輪到" + topPlayer.getName() + "了");

		System.out.println(topPlayer.showHandCardIndexes());
		System.out.println(topPlayer.showHandCards());

		CardHandler<?> handler = new SingleHandler(new PairHandler(new StraightHandler(new FullHouseHandler(null))));

		List<Card> playedCards = topPlayer.play();
		CardPattern<?> pattern = handler.handle(playedCards);

		System.out.println("玩家 " + topPlayer.getName() + " 打出了 " + pattern.toString());

		int index = players.indexOf(topPlayer);
		while (winner == null) {
			index = (index + 1) % players.size();
			Player currentPlayer = players.get(index);

			System.out.println("輪到" + currentPlayer.getName() + "了");

			System.out.println(currentPlayer.showHandCardIndexes());
			System.out.println(currentPlayer.showHandCards());

			// TODO: 處理玩家出牌或過牌的邏輯
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
			// 假設 Card 類別有一個方法 isClub3() 用來檢查是否是梅花3
			for (int i = 0; i < 13; i++) {
				Card card = player.getHandCard(i);
				if (card.isClub3()) {
					return player;
				}
			}
		}
		return null;
	}
}
