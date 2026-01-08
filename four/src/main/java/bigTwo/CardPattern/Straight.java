package bigTwo.CardPattern;

import java.util.List;
import bigTwo.Card.Card;

public class Straight extends CardPattern<Straight> {
    private int size = 5;

    public Straight(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public int compareTo(Straight other) {
        Card thisHighest = this.getHighestCard();
        Card otherHighest = other.getHighestCard();

        int rankCmp = Integer.compare(thisHighest.getRankValue(), otherHighest.getRankValue());
        if (rankCmp != 0) {
            return rankCmp;
        }

        return Integer.compare(thisHighest.getSuitValue(), otherHighest.getSuitValue());
    }

    @Override
    public boolean validate(List<Card> cards) {
        if (!isValidSize(cards)) {
            return false;
        }
        for (int i = 0; i < size - 1; i++) {
            Card a = cards.get(i);
            Card b = cards.get(i + 1);
            int currentRank = a.getRankValue();
            int nextRank = b.getRankValue();
            if (nextRank != currentRank + 1) {
                return false;
            }
        }
        
        return true;
    }

    private Card getHighestCard() {
        Card highest = getCard(0);
        for (Card card : cards) {
            if (card.getRankValue() > highest.getRankValue() ||
                    (card.getRankValue() == highest.getRankValue() &&
                            card.getSuitValue() > highest.getSuitValue())) {
                highest = card;
            }
        }
        return highest;
    }
}
