package bigTwo.CardPattern;

import bigTwo.Card.Card;

import java.util.ArrayList;
import java.util.List;

public abstract class CardPattern<T extends CardPattern<T>> {
    protected int size;

    protected List<Card> cards = new ArrayList<>();

    public abstract int compareTo(T other);

    public abstract boolean validate(List<Card> cards);

    public int getSize() {
        return size;
    }

    public List<Card> getCards() {
        return cards;
    }
}
