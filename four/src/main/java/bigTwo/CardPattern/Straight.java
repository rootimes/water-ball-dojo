package bigTwo.cardpattern;

import java.util.List;

import bigTwo.card.Card;

public class Straight extends CardPattern<Straight> {

	public Straight(List<Card> cards) {
		this.size = 5;
		this.name = "順子";
		this.cards = cards;
	}

	@Override
	protected int compareToSameType(Straight other) {
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

		final int RANKS = 13;
		boolean[] present = new boolean[RANKS];

		for (Card c : cards) {
			int r = c.getRankValue();
			if (r < 0 || r >= RANKS)
				return false;
			if (present[r])
				return false;
			present[r] = true;
		}

		int n = cards.size();

		for (int start = 0; start < RANKS; start++) {
			if (!present[start])
				continue;

			boolean ok = true;
			for (int step = 1; step < n; step++) {
				int expected = (start + step) % RANKS;
				if (!present[expected]) {
					ok = false;
					break;
				}
			}
			if (ok)
				return true;
		}

		return false;
	}

	private Card getHighestCard() {
		Card highest = getCard(0);
		for (Card card : cards) {
			if (card.getRankValue() > highest.getRankValue() || (card.getRankValue() == highest.getRankValue()
					&& card.getSuitValue() > highest.getSuitValue())) {
				highest = card;
			}
		}
		return highest;
	}
}
