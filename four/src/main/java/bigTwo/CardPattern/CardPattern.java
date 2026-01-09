package bigTwo.CardPattern;

import java.util.ArrayList;
import java.util.List;

import bigTwo.Card.Card;

public abstract class CardPattern<T extends CardPattern<T>> {
	protected int size;

	protected String name;

	protected List<Card> cards = new ArrayList<>();

	@SuppressWarnings("unchecked")
	public int compareTo(CardPattern<?> other) {
		return compareToSameType((T) other);
	}

	protected abstract int compareToSameType(T other);

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

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.name).append(" ");

		for (Card card : cards) {
			sb.append(card.toString()).append(" ");
		}

		return sb.toString().trim();
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
