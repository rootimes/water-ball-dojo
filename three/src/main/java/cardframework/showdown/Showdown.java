package cardframework.showdown;

import cardframework.Player;
import cardframework.showdown.card.Card;
import cardframework.showdown.deck.Deck;
import cardframework.showdown.player.HumanPlayer;

import java.util.HashMap;
import java.util.Map;

public class Showdown extends cardframework.Game<Card> {
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
        System.out.println("Playing rounds of Showdown Poker...");
        
        Map<Player<Card>, Card> playerCards = new HashMap<>();

        for (Player<Card> player : players) {
            Card showCard = player.takeTurn();
            playerCards.put(player, showCard);
        }
    }
}