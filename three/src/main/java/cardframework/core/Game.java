package cardframework.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Game<T extends Card, P extends Player<T>> {

  protected Deck<T> deck;

  protected List<P> players = new ArrayList<>();

  protected int MAX_PLAYERS;

  protected int CARDS_PER_PLAYER;

  protected Player<T> finalWinner;

  protected Scanner scanner = new Scanner(System.in);

  public final void run() {
    setup();
    start();
    end();
  }
  ;

  private void setup() {

    System.out.println("Starting the game...");

    System.out.println("How many players?");

    int numPlayers = scanner.nextInt();

    scanner.nextLine();

    if (numPlayers <= MAX_PLAYERS) {
      for (int i = 0; i < numPlayers; i++) {
        players.add(createHumanPlayer());
      }

      for (int i = numPlayers; i < MAX_PLAYERS; i++) {
        P aiPlayer = createAIPlayer();
        aiPlayer.setName("AI Player " + (i + 1 - numPlayers));
        players.add(aiPlayer);
      }
    }

    this.deck = setDeck();

    this.deck.shuffle();
  }
  ;

  private void start() {
    for (int i = 0; i < players.size(); i++) {
      P player = players.get(i);
      if (isHumanPlayer(player)) {
        System.out.println("Enter name for Player " + (i + 1) + ": ");
        String name = scanner.nextLine();
        player.setName(name);
      }
    }

    for (int i = 0; i < CARDS_PER_PLAYER; i++) {
      for (P player : players) {
        player.drawCard(deck);
      }
    }

    System.out.println("Playing rounds of " + this.getClass().getSimpleName() + "...");

    beforeRound();

    playRound();
  }
  ;

  private void end() {
    System.out.println("Ending the game...");

    System.out.println("The final winner is: " + finalWinner.getName());
  }
  ;

  protected abstract P createHumanPlayer();

  protected abstract P createAIPlayer();

  protected abstract boolean isHumanPlayer(P player);

  protected abstract Deck<T> setDeck();

  protected abstract void beforeRound();

  protected abstract void playRound();

  protected abstract boolean isGameOver();
}
