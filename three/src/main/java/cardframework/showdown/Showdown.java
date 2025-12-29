package cardframework.showdown;

import java.util.HashMap;
import java.util.Map;

import cardframework.showdown.card.Card;
import cardframework.showdown.deck.Deck;
import cardframework.showdown.player.AIPlayer;
import cardframework.showdown.player.HumanPlayer;
import cardframework.showdown.player.Player;

public class Showdown extends cardframework.core.Game<Card, Player> {

  protected static final int MAX_PLAYERS = 4;

  protected static final int MAX_ROUNDS = 13;

  protected static final int CARDS_PER_PLAYER = 13;

  @Override
  protected Player createHumanPlayer() {
    return new HumanPlayer();
  }

  @Override
  protected Player createAIPlayer() {
    return new AIPlayer();
  }

  @Override
  protected Deck setDeck() {
    return new Deck();
  }

  @Override
  protected boolean isHumanPlayer(Player player) {
    return player instanceof HumanPlayer;
  }

  @Override
  protected void playRounds() {
    System.out.println("Playing rounds of Showdown Poker...");

    Map<Player, Card> playerCards = new HashMap<>();

    for (int round = 1; round <= MAX_ROUNDS; round++) {
      System.out.println("Starting round " + round);

      for (Player player : players) {
        Card showCard = player.takeTurn();
        playerCards.put(player, showCard);
      }

      Player roundWinner = pickRoundWinner(playerCards);

      System.out.println("Round winner: " + roundWinner.getName());

      roundWinner.addScore(1);
    }

    Player finalWinner =
        players.stream()
            .max((p1, p2) -> Integer.compare(p1.getScore(), p2.getScore()))
            .orElse(null);

    this.finalWinner = finalWinner;
  }

  private Player pickRoundWinner(Map<Player, Card> playerCards) {
    Player winner = null;
    Card highestCard = null;

    for (Map.Entry<Player, Card> entry : playerCards.entrySet()) {
      Player player = entry.getKey();
      Card card = entry.getValue();

      if (highestCard == null || card.compareTo(highestCard) > 0) {
        highestCard = card;
        winner = player;
      }
    }

    return winner;
  }
}
