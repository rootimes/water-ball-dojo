package cardframework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Game<T extends Card> {

    protected Deck<T> deck;

    protected List<Player<T>> players = new ArrayList<>();

    protected int MAX_PLAYERS = 4;

    protected int MAX_ROUNDS = 13;

    protected Scanner scanner = new Scanner(System.in);

    final public void setup() {

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

    final public void start() {
        for (Player<T> player : players) {
            if (isHumanPlayer(player)) {
                System.out.println("Enter name for player:");
                String name = scanner.nextLine();
                player.setName(name);
            }
        }

        System.out.println("Game is now in progress...");

        playRounds();
    };

    final public void end() {
        System.out.println("Ending the game...");
    };

    protected abstract Player<T> createHumanPlayer();

    protected abstract boolean isHumanPlayer(Player<T> player);

    protected abstract Deck<T> setDeck();

    protected abstract void playRounds();
}
