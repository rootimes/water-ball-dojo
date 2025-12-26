package cardframework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Game {

    protected Deck<?> deck;

    protected List<Player> players = new ArrayList<>();

    protected int MAX_PLAYERS = 4;

    protected int MAX_ROUNDS = 13;

    final public void setup() {
        
        System.out.println("How many players?");

        Scanner scanner = new Scanner(System.in);
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        if (numPlayers < MAX_PLAYERS) {
            for (int i = 0; i < numPlayers; i++) {
                players.add(createHumanPlayer());
            }
        }

        scanner.close();

        deck = setDeck();
        deck.shuffle();
    };

    final public void start() {
        System.out.println("Starting the game...");

        setup();

        System.out.println("Game is now in progress...");

        playRounds();
    };

    final public void end() {
        System.out.println("Ending the game...");
    };

    protected abstract Player createHumanPlayer();

    protected abstract Deck<?> setDeck();

    protected abstract void playRounds();
}
