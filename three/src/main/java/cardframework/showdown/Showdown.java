package cardframework.showdown;

import cardframework.showdown.player.Player;
import cardframework.showdown.player.HumanPlayer;

public class Showdown extends cardframework.Game {
    protected void setup() {
        System.out.println("Setting up Showdown Poker Game...");
        // Setup logic would go here
    }

    protected Player createHumanPlayer() {
        HumanPlayer humanPlayer = new HumanPlayer();

        return humanPlayer;
    }

    protected void playRounds() {
        System.out.println("Playing rounds of Showdown Poker...");
        // Gameplay logic would go here
    }
}
