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
		
		// 先排序牌，以便檢查是否為連續數字
		List<Card> sortedCards = cards.stream()
				.sorted((a, b) -> Integer.compare(a.getRankValue(), b.getRankValue()))
				.toList();
		
		for (int i = 0; i < size - 1; i++) {
			Card a = sortedCards.get(i);
			Card b = sortedCards.get(i + 1);
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
			if (card.getRankValue() > highest.getRankValue() || (card.getRankValue() == highest.getRankValue()
					&& card.getSuitValue() > highest.getSuitValue())) {
				highest = card;
			}
		}
		return highest;
	}
}
