package showdown.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import showdown.player.Player;
import showdown.player.HumanPlayer;
import showdown.player.AIPlayer;
import showdown.deck.Deck;
import showdown.card.Card;

public class ShowdownGame {

    private static final int MAX_PLAYERS = 4;

    private static final int TOTAL_ROUNDS = 13;

    Scanner scanner = new Scanner(System.in);

    List<Player> players = new ArrayList<>();

    Deck deck;

    public void start() {

        System.out.println("遊戲開始！");

        setupHumanPlayerNumber();

        namePlayers();
        
        setupDeck();

        dealCards();
    }

    private void setupHumanPlayerNumber() {
        System.out.println("請輸入人類玩家數量 (最多 " + MAX_PLAYERS + " 人):");

        int numberOfHumanPlayers = readIntRange(1, MAX_PLAYERS);

        for (int i = 1; i <= numberOfHumanPlayers; i++) {
            players.add(new HumanPlayer());
        }

        for (int i = numberOfHumanPlayers + 1; i <= MAX_PLAYERS; i++) {
            players.add(new AIPlayer());
        }

        System.out.println("玩家設定完成，共有 " + numberOfHumanPlayers + " 位人類玩家參與遊戲，其餘為 AI 玩家。");
    }

    private int readIntRange(int min, int max) {
        while (true) {
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value >= min && value <= max) {
                    return value;
                }
            } else {
                scanner.nextLine();
            }

            System.out.println("輸入無效，請輸入介於 " + min + " 和 " + max + " 之間的整數：");
        }
    }

    private void namePlayers() {
        int aiCount = 1;
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player instanceof HumanPlayer) {
                System.out.println("請輸入第 " + (i + 1) + " 位人類玩家的名稱：");
                String name = scanner.next();
                player.setName(name);
            } else {
                player.setName("AI" + aiCount + "號機");
                aiCount++;
            }
        }

        System.out.println("玩家命名完成，以下是所有玩家的名稱：");
        for (Player player : players) {
            System.out.println("- " + player.getName());
        }
    }

    private void setupDeck() {
        deck = new Deck();
        deck.shuffle();
    }

    private void dealCards() {
        int cardsPerPlayer = deck.size() / players.size();
        for (int i = 0; i < cardsPerPlayer; i++) {
            for (Player player : players) {
                Card card = deck.draw();
                player.addCard(card);
            }
        }
    }
}
