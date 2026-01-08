package bigTwo.CardPattern;

import java.util.ArrayList;
import java.util.List;

import bigTwo.Card.Card;

public abstract class CardPattern<T extends CardPattern<T>> {
	protected int size;

	protected List<Card> cards = new ArrayList<>();

	public abstract int compareTo(T other);

	public abstract boolean validate(List<Card> cards);

	public int getSize() {
		return size;
	}

	public Card getCard(int index) {
		return cards.get(index);
	}

	public List<Card> getCards() {
		return cards;
	}

	protected boolean isValidSize(List<Card> cards) {
		for (Card card : cards) {
			if (card == null) {
				return false;
			}
		}

		return cards.size() == size;
	}
}
