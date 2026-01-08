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
        Card a = this.getCard(0);
        Card b = other.getCard(0);

        int rankCmp = Integer.compare(a.getRankValue(), b.getRankValue());
        if (rankCmp != 0) {
            return rankCmp;
        }

        return Integer.compare(a.getSuitValue(), b.getSuitValue());
    }

    @Override
    public boolean validate(List<Card> cards) {
        return isValidSize(cards);
    }
}
