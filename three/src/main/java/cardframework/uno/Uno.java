package cardframework.uno;

import cardframework.uno.player.Player;

public class Uno extends cardframework.Game {
    protected void setup() {
        System.out.println("Setting up Uno Game...");
        // Setup logic would go here
    }

    protected Player createHumanPlayer() {
        Player humanPlayer = new Player();

        return humanPlayer;
    }

    protected void playRounds() {
        System.out.println("Playing rounds of Uno...");
        // Gameplay logic would go here
    }
}
