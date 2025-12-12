package showdown.game;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

import showdown.player.Player;
import showdown.player.HumanPlayer;
import showdown.player.AIPlayer;
import showdown.deck.Deck;
import showdown.card.Card;
import showdown.round.ExchangeRecord;
import showdown.round.Round;
import java.util.Iterator;

public class ShowdownGame {

    private static final int MAX_PLAYERS = 4;

    private static final int TOTAL_ROUNDS = 13;

    private static final int POINTS_PER_WIN = 1;

    private Map<Player, Boolean> exchanged = new LinkedHashMap<>();

    private List<ExchangeRecord> exchangeRecords = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    List<Player> players = new ArrayList<>();

    Deck deck;

    public void run() {

        System.out.println("遊戲開始！");

        setupHumanPlayerNumber();

        nameHumanPlayers();

        setupDeck();

        drawCards();

        playRounds();
    }

    public void end() {
        System.out.println("遊戲結束！以下是最終得分：");

        for (Player player : players) {
            System.out.println(player.getName() + " 的得分: " + player.getScore());
        }

        Player finalWinner = getTopScorer(players);
        System.out.println("最終贏家是 " + finalWinner.getName() + "，得分為: " + finalWinner.getScore() + " 分！");
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
                scanner.nextLine();
                if (value >= min && value <= max) {
                    return value;
                }
            }
            scanner.nextLine();

            System.out.println("輸入無效，請輸入介於 " + min + " 和 " + max + " 之間的整數：");
        }
    }

    private void nameHumanPlayers() {
        int aiCount = 1;
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (player instanceof HumanPlayer) {
                System.out.println("請輸入第 " + (i + 1) + " 位人類玩家的名稱：");
                String name = scanner.next();
                player.setName(name);
            } else {
                player.setName("AI " + aiCount + "號機");
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

    private void drawCards() {
        int cardsPerPlayer = deck.size() / players.size();
        for (int i = 0; i < cardsPerPlayer; i++) {
            for (Player player : players) {
                Card card = deck.draw();
                player.addCard(card);
            }
        }
    }

    private void playRounds() {
        for (int roundNumber = 1; roundNumber <= TOTAL_ROUNDS; roundNumber++) {
            System.out.println("第 " + roundNumber + " 回合開始！");

            Map<Player, Card> activePlayers = new LinkedHashMap<>();

            for (Player player : players) {
                Card chosenCard = null;

                if (player.hasCards() == false) {
                    continue; // 如果玩家沒有卡牌，跳過此玩家
                }

                if (player instanceof HumanPlayer) {
                    System.out.print(player.displayCards().toString());

                    if (!isExchangeLocked(player)) {
                        System.out.println(player.getName() + "，是否要交換手牌？ (1: 是, 0: 否)");
                        int exchange = readIntRange(0, 1);

                        if (exchange == 1) {
                            Player targetPlayer = exchangeTargetPlayer(player);
                            player.exchangeHandCards(targetPlayer);
                            exchanged.put(player, true); // 標記為已交換

                            System.out.print(player.displayCards().toString());

                            exchangeRecords.add(new ExchangeRecord(player, targetPlayer, 3));
                        }
                    }

                    chosenCard = humanPlayerChoiceCard((HumanPlayer) player);
                } else if (player instanceof AIPlayer) {
                    chosenCard = aiPlayerChoiceCard((AIPlayer) player);
                }

                activePlayers.put(player, chosenCard);
            }

            if (activePlayers.isEmpty()) {
                continue; // 如果沒有玩家出牌，跳過此回合
            }

            Round round = new Round(activePlayers, roundNumber);

            processRound(round);

            updateExchangeRecords();

            System.out.println("第 " + roundNumber + " 回合結束！請按下 Enter 鍵以繼續...");

            scanner.nextLine(); // 等待玩家按下 Enter 鍵以繼續
        }
    }

    private boolean isExchangeLocked(Player player) {
        for (ExchangeRecord record : exchangeRecords) {
            if (record.getPlayers().contains(player)) {
                return true;
            }
        }
        return exchanged.getOrDefault(player, false);
    }

    private Player exchangeTargetPlayer(Player currentPlayer) {
        System.out.println(currentPlayer.getName() + "，請選擇要交換手牌的玩家索引：");

        List<Player> candidates = new ArrayList<>();
        for (Player player : players) {
            if (player != currentPlayer && !isExchangeLocked(player)) {
                candidates.add(player);
                System.out.println(candidates.size() - 1 + ": " + player.getName());
            }
        }

        int playerIndex = readIntRange(0, candidates.size() - 1);

        Player otherPlayer = candidates.get(playerIndex);
        while (otherPlayer == null) {
            System.out.println("無效的玩家索引，請重新選擇：");
            playerIndex = readIntRange(0, candidates.size() - 1);
            otherPlayer = candidates.get(playerIndex);
        }

        return otherPlayer;
    }

    private Card humanPlayerChoiceCard(HumanPlayer player) {

        System.out.println(player.getName() + "，請選擇要出的卡牌索引 (0 - " + (player.getHandCards().size() - 1) + "):");
        int cardIndex = readIntRange(0, player.getHandCards().size() - 1);
        Card chosenCard = player.showCard(cardIndex);

        while (chosenCard == null) {
            System.out.println("無效的卡牌索引，請重新選擇：");
            cardIndex = readIntRange(0, player.getHandCards().size() - 1);
            chosenCard = player.showCard(cardIndex);
        }

        return chosenCard;
    }

    private Card aiPlayerChoiceCard(AIPlayer player) {

        System.out.println(player.getName() + " 正在思考要出的卡牌...");
        int cardIndex = player.thinkCardIndex();
        Card chosenCard = player.showCard(cardIndex);

        return chosenCard;
    }

    private void processRound(Round round) {
        System.out.println(round.displayRoundCards().toString());

        Map.Entry<Player, Card> result = round.compare();

        Player winner = result.getKey();

        Card winningCard = result.getValue();

        winner.addScore(POINTS_PER_WIN);

        System.out.println("本回合獲勝者是 " + winner.getName() + "，出牌為 " +
                winningCard.getSuit() + ":" + winningCard.getRank() + "！");
    }

    private void updateExchangeRecords() {
        Iterator<ExchangeRecord> iterator = exchangeRecords.iterator();
        while (iterator.hasNext()) {
            ExchangeRecord record = iterator.next();
            record.decreaseRoundsLeft();
            if (record.getRoundsLeft() <= 0) {
                List<Player> players = record.getPlayers();
                Player player1 = players.get(0);
                Player player2 = players.get(1);

                player1.exchangeHandCards(player2);

                iterator.remove();
            }
        }
    }

    private Player getTopScorer(List<Player> players) {
        Player topScorer = null;
        int highestScore = -1;

        for (Player player : players) {
            if (player.getScore() > highestScore) {
                highestScore = player.getScore();
                topScorer = player;
            }
        }

        return topScorer;
    }
}
