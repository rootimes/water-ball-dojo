package cardframework.showdown;

import java.util.HashMap;
import java.util.Map;

import cardframework.showdown.card.Card;
import cardframework.showdown.deck.Deck;
import cardframework.showdown.player.AIPlayer;
import cardframework.showdown.player.HumanPlayer;
import cardframework.showdown.player.Player;

public class Showdown extends cardframework.core.Game<Card, Player> {

  protected static final int MAX_ROUNDS = 13;

  protected int currentRound = 0;

  public Showdown() {
    this.MAX_PLAYERS = 4;
    this.CARDS_PER_PLAYER = 13;
  }

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
  protected void beforeRound() {
  }

  @Override
  protected void playRound() {
    currentRound++;
    System.out.println("Starting round " + currentRound);

    Player winner = null;
    Card highestCard = null;
    for (Player player : players) {
      Card showCard = player.takeTurn();

      if (highestCard == null || showCard.compareTo(highestCard) > 0) {
        highestCard = showCard;
        winner = player;
      }
    }

    System.out.println("Round winner: " + winner.getName());
    winner.addScore(1);

    if (isGameOver()) {
      Player finalWinner = players.stream()
          .max((p1, p2) -> Integer.compare(p1.getScore(), p2.getScore()))
          .orElse(null);

      this.finalWinner = finalWinner;
    } else {
      playRound();
    }
  }

  protected boolean isGameOver() {
    return currentRound >= MAX_ROUNDS;
  }

}
