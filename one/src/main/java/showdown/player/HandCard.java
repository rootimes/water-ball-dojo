package showdown.player;

import java.util.ArrayList;
import java.util.List;
import showdown.card.Card;

public class HandCard {

    private List<Card> cards = new ArrayList<>();

    public boolean add(Card card) {
        return cards.add(card);
    }

    public Card get(int index) {
        return cards.get(index);
    }

    public Card remove(int index) {
        return cards.remove(index);
    }

    public int size() {
        return cards.size();
    }
}
