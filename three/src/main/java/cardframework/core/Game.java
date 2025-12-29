package cardframework.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Game<T extends Card, P extends Player<T>> {

    protected Deck<T> deck;

    protected List<P> players = new ArrayList<>();

    protected int MAX_PLAYERS = 4;

    protected int CARDS_PER_PLAYER = 13;

    protected Player<T> finalWinner;

    protected Scanner scanner = new Scanner(System.in);

    final public void run() {
        setup();
        start();
        end();
    };

    private void setup() {

        System.out.println("Starting the game...");

        System.out.println("How many players?");

        int numPlayers = scanner.nextInt();

        scanner.nextLine();

        if (numPlayers < MAX_PLAYERS) {
            for (int i = 0; i < numPlayers; i++) {
                players.add(createHumanPlayer());
            }
        }

        this.deck = setDeck();

        this.deck.shuffle();

    };

    private void start() {
        for (int i = 0; i < players.size(); i++) {
            P player = players.get(i);
            if (isHumanPlayer(player)) {
                System.out.println("Enter name for Player " + (i + 1) + ": ");
                String name = scanner.nextLine();
                player.setName(name);
            }
        }

        drawCards();

        System.out.println("Game is now in progress...");

        playRounds();
    };

    private void end() {

        System.out.println("Ending the game...");

        System.out.println("The final winner is: " + finalWinner.getName());

    };

    protected void drawCards() {
        for (int i = 0; i < CARDS_PER_PLAYER; i++) {
            for (P player : players) {
                player.drawCard(deck);
            }
        }
    }

    protected abstract P createHumanPlayer();

    protected abstract boolean isHumanPlayer(P player);

    protected abstract Deck<T> setDeck();

    protected abstract void playRounds();
}
