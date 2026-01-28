package showdown.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import showdown.card.Card;
import showdown.card.Rank;
import showdown.card.Suit;

public class Deck {

	private final List<Card> cards = new ArrayList<>();

	public Deck() {
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new Card(rank, suit));
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card draw() {
		if (this.isEmpty()) {
			throw new IllegalStateException("No more cards.");
		}
		return cards.remove(cards.size() - 1);
	}

	public int size() {
		return cards.size();
	}

	private boolean isEmpty() {
		return cards.isEmpty();
	}
}
