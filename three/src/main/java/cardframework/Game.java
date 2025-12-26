package cardframework;

import java.util.List;
import java.util.Scanner;

public abstract class Game {

    protected List<Player> players;

    protected int MAX_PLAYERS = 4;

    protected int MAX_ROUNDS = 13;

    final public void start() {
        System.out.println("Starting the game...");

        setup();

        System.out.println("Game is now in progress...");

        playRounds();
    };

    final public void end() {
        System.out.println("Ending the game...");
    };

    protected void setup() {
        
        System.out.println("How many players?");

        Scanner scanner = new Scanner(System.in);
        int numPlayers = scanner.nextInt();

        if (numPlayers < MAX_PLAYERS) {
            for (int i = 0; i < numPlayers; i++) {
                players.add(createHumanPlayer());
            }
        }

        
    };

    protected abstract Player createHumanPlayer();

    protected abstract void playRounds();
}
