package cardframework.uno;

import cardframework.uno.card.Card;
import cardframework.uno.deck.Deck;
import cardframework.uno.player.HumanPlayer;
import cardframework.uno.player.Player;

public class Uno extends cardframework.Game<Card, Player> {

    protected static final int CARDS_PER_PLAYER = 5;

    @Override
    protected Player createHumanPlayer() {
        return new HumanPlayer();
    }

    @Override
    protected Deck setDeck() {
        return new Deck();
    }

    @Override
    protected boolean isHumanPlayer(Player player) {
        return player instanceof HumanPlayer;
    }

    @Override
    protected void playRounds() {
        System.out.println("Playing rounds of Uno...");
        // Gameplay logic would go here
    }
}
