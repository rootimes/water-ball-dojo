package bigTwo.player;

import java.util.ArrayList;
import java.util.List;

import bigTwo.card.Card;

public class HandCard {

	protected List<Card> cards = new ArrayList<>();

	public int size() {
		return cards.size();
	}

	public void add(Card card) {
		cards.add(card);
	}

	public Card getCard(int index) {
		return cards.get(index);
	}

	public List<Card> getCards() {
		return cards;
	}

	public void sort() {
		cards.sort(Card::compareTo);
	}

	public boolean removeCards(List<Card> cards) {
		return this.cards.removeAll(cards);
	}
}
