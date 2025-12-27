package cardframework.uno;

import cardframework.Player;
import cardframework.uno.card.Card;
import cardframework.uno.deck.Deck;
import cardframework.uno.player.HumanPlayer;

public class Uno extends cardframework.Game<Card> {
    @Override
    protected Player<Card> createHumanPlayer() {
        return new HumanPlayer();
    }

    @Override
    protected Deck setDeck() {
        return new Deck();
    }

    @Override
    protected boolean isHumanPlayer(Player<Card> player) {
        return player instanceof HumanPlayer;
    }

    @Override
    protected void playRounds() {
        System.out.println("Playing rounds of Uno...");
        // Gameplay logic would go here
    }
}
