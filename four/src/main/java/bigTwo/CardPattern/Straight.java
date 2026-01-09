package bigTwo.CardPattern;

import java.util.List;

import bigTwo.Card.Card;

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

		final int MAX_RANK = 12;

		// 先排序牌，以便檢查是否為連續數字
		List<Card> sortedCards = cards.stream()
				.sorted((a, b) -> Integer.compare(a.getRankValue(), b.getRankValue()))
				.toList();

		if (isStraight(sortedCards)) {
			return true;
		}

		List<Integer> wrappedRanks = sortedCards.stream()
				.map(card -> card.getRankValue() == 0 ? MAX_RANK + 1 : card.getRankValue())
				.sorted()
				.toList();

		return isStraightValues(wrappedRanks);
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

	private boolean isStraight(List<Card> cards) {
		for (int i = 0; i < cards.size() - 1; i++) {
			int current = cards.get(i).getRankValue();
			int next = cards.get(i + 1).getRankValue();
			if (next != current + 1) {
				return false;
			}
		}
		return true;
	}

	private boolean isStraightValues(List<Integer> values) {
		for (int i = 0; i < values.size() - 1; i++) {
			if (values.get(i + 1) != values.get(i) + 1) {
				return false;
			}
		}
		return true;
	}
}
