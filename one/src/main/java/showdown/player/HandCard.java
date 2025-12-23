package showdown.player;

import java.util.ArrayList;
import java.util.List;
import showdown.card.Card;

public class HandCard {

    private List<Card> cards = new ArrayList<>();

    public void add(Card card) {
        cards.add(card);
    }
    
    public void remove(Card card) {
        cards.remove(card);
    }

    public int size() {
        return cards.size();
    }
}
