package bigTwo.CardPattern;

import bigTwo.Card.Card;
import java.util.List;

public class Single extends CardPattern<Single> {
    private int size = 1;

    public Single(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public int compareTo(Single other) {
        Card a = this.cards.get(0);
        Card b = other.cards.get(0);

        int rankCmp = Integer.compare(a.getRankValue(), b.getRankValue());
        if (rankCmp != 0)
            return rankCmp;
        
        return Integer.compare(a.getSuitValue(), b.getSuitValue());
    }

    @Override
    public boolean validate(List<Card> cards) {
        if (cards == null) {
            return false;
        }

        if (cards.size() != size) {
            return false;
        }
        return true;
    }
}
