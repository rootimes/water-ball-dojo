package cardframework.showdown;

import cardframework.showdown.player.Player;
import cardframework.showdown.deck.Deck;
import cardframework.showdown.player.HumanPlayer;

public class Showdown extends cardframework.Game {
    protected Player createHumanPlayer() {
        HumanPlayer humanPlayer = new HumanPlayer();

        return humanPlayer;
    }

    @Override
    protected Deck setDeck() {
        return new Deck();
    }

    @Override
    protected void playRounds() {
        System.out.println("Playing rounds of Showdown Poker...");
        // Gameplay logic would go here
    }
}
