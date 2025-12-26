package cardframework.uno;

import cardframework.uno.player.Player;
import cardframework.uno.deck.Deck;

public class Uno extends cardframework.Game {
    protected Player createHumanPlayer() {
        Player humanPlayer = new Player();

        return humanPlayer;
    }

    @Override
    protected Deck setDeck() {
        return new Deck();
    }

    @Override
    protected void playRounds() {
        System.out.println("Playing rounds of Uno...");
        // Gameplay logic would go here
    }
}
