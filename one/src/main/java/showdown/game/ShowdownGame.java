package showdown.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import showdown.player.Player;
import showdown.player.HumanPlayer;
import showdown.player.AIPlayer;
import showdown.deck.Deck;
import showdown.card.Card;

public class ShowdownGame {

    private static final int MAX_PLAYER_NUMBER = 4;

    private static final int MAX_ROUNDS = 13;

    Scanner scanner = new Scanner(System.in);

    List<Player> players = new ArrayList<>();

    Deck deck;

    public void setup() {

        System.out.println("設定操作玩家數量：");
        int humanPlayerCount = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= humanPlayerCount; i++) {
            Player player = new HumanPlayer();
            players.add(player);
        }

        for (int i = humanPlayerCount + 1; i <= MAX_PLAYER_NUMBER; i++) {
            Player player = new AIPlayer();
            players.add(player);
        }

        deck = new Deck();
        deck.shuffle();
    }

    public void start() {

        System.out.println("遊戲開始！");

        for (Player player : players) {
            if (player instanceof HumanPlayer) {
                System.out.println("請輸入玩家名稱：");
                String name = scanner.nextLine();
                player.setName(name);
            } else {
                player.setName("AI 玩家");
            }
        }

        while (deck.size() >= players.size()) {
            for (Player player : players) {
                player.drawCard(deck);
            }
        }

        for (int round = 1; round <= MAX_ROUNDS; round++) {
            System.out.println("第 " + round + " 回合開始！");
            playRound(players);
        }
    }

    private void playRound(List<Player> players) {
        Map<Player, Card> playedCards = new HashMap<>();
        for (Player player : players) {
            List<Player> candidates = getExchangeCandidates(player);
            Card showCard = player.takeTurn(candidates);

            if (showCard != null) {
                playedCards.put(player, showCard);
            } else {
                System.out.println(player.getName() + " 沒有牌可出，跳過此回合。");
            }
        }

        for (Player player : players) {
            player.updateExchangeState();
        }

        Player winner = pickWinPlayer(playedCards);

        if (winner != null) {
            System.out.println("本回合贏家是: " + winner.getName());
            winner.addScore(1);
        } else {
            System.out.println("本回合沒有贏家。");
        }
    }

    private List<Player> getExchangeCandidates(Player currentPlayer) {

        List<Player> candidates = new ArrayList<>();

        for (Player player : players) {
            if (player != currentPlayer && !player.hasUsedExchange() && player.getExchangeState() == null) {
                candidates.add(player);
            }
        }

        return candidates;
    }

    private Player pickWinPlayer(Map<Player, Card> playedCards) {

        Player winner = null;
        Card maxCard = null;

        for (Map.Entry<Player, Card> entry : playedCards.entrySet()) {
            Card card = entry.getValue();
            if (maxCard == null || card.compareTo(maxCard) > 0) {
                maxCard = card;
                winner = entry.getKey();
            }
        }

        return winner;
    }

    public void end() {

        System.out.println("遊戲結束！");

    }

}
