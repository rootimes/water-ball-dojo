package bigTwo.CardPattern;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bigTwo.Card.Card;

public class FullHouse extends CardPattern<FullHouse> {
	private int size = 5;

	private String name = "葫蘆";

	public FullHouse(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	protected int compareToSameType(FullHouse other) {

		int thisThreeRank = tripleRankValue(this.cards);

		int otherThreeRank = tripleRankValue(other.cards);

		return Integer.compare(thisThreeRank, otherThreeRank);
	}

	@Override
	public boolean validate(List<Card> cards) {
		if (!isValidSize(cards)) {
			return false;
		}

		Map<Integer, Integer> rankCount = new HashMap<>();

		for (Card card : cards) {
			int rank = card.getRankValue();
			rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
		}

		if (rankCount.size() != 2) {
			return false;
		}

		boolean hasThree = false;
		boolean hasTwo = false;

		for (int count : rankCount.values()) {
			if (count == 3) {
				hasThree = true;
			} else if (count == 2) {
				hasTwo = true;
			}
		}

		return hasThree && hasTwo;
	}

	private int tripleRankValue(List<Card> cards) {
		Map<Integer, Integer> rankCount = new HashMap<>();
		for (Card card : cards) {
			int rank = card.getRankValue();
			rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : rankCount.entrySet()) {
			if (entry.getValue() == 3) {
				return entry.getKey();
			}
		}

		throw new IllegalStateException("Invalid Full House: No triple found.");
	}
}
