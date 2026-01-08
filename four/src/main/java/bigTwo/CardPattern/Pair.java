package bigTwo.CardPattern;

import java.util.List;

import bigTwo.Card.Card;

public class Pair extends CardPattern<Pair> {
	private int size = 2;

	public Pair(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public int compareTo(Pair other) {
		Card a1 = this.getCard(0);
		Card a2 = this.getCard(1);
		Card b1 = other.getCard(0);
		Card b2 = other.getCard(1);

		int rankCmp = Integer.compare(a1.getRankValue(), b1.getRankValue());
		if (rankCmp != 0) {
			return rankCmp;
		}

		int suitA = Math.max(a1.getSuitValue(), a2.getSuitValue());
		int suitB = Math.max(b1.getSuitValue(), b2.getSuitValue());

		return Integer.compare(suitA, suitB);
	}

	@Override
	public boolean validate(List<Card> cards) {
		if (!isValidSize(cards)) {
			return false;
		}

		Card a = cards.get(0);
		Card b = cards.get(1);
		if (a.getRankValue() != b.getRankValue()) {
			return false;
		}

		return true;
	}
}
