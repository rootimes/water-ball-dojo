package bigTwo.Card;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private List<Card> cards = new ArrayList<>();

    public Deck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card deal() {
        if (!cards.isEmpty()) {
            return cards.remove(cards.size() - 1);
        }

        return null;
    }
}
