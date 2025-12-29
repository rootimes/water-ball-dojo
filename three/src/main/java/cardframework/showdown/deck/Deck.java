package cardframework.showdown.deck;

import cardframework.showdown.card.Suit;
import cardframework.showdown.card.Rank;
import cardframework.showdown.card.Card;

public class Deck extends cardframework.core.Deck<Card>  {

    public Deck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }
}
