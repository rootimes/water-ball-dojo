package cardframework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Deck<TCard> {
    
    protected final List<TCard> cards = new ArrayList<>();
    
    public void shuffle() {
        Collections.shuffle(cards);
    }

    public TCard draw() {
        if (this.size() == 0) {
            throw new IllegalStateException("No cards left in the deck to draw.");
        }

        return cards.remove(cards.size() - 1);
    }

    public int size() {
        return cards.size();
    }
}
