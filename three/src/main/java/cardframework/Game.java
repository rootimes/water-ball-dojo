package cardframework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Game {

    protected Deck<?> deck;

    protected List<Player> players = new ArrayList<>();

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

        setPlayerNames(players);

        System.out.println("Game is now in progress...");

        playRounds();
    };

    final public void end() {
        System.out.println("Ending the game...");
    };

    
    protected abstract Player createHumanPlayer();
    
    protected abstract void setPlayerNames(List<Player> players);

    protected abstract Deck<?> setDeck();

    protected abstract void playRounds();
}
