package bigTwo.CardHandler;

import java.util.List;

import bigTwo.Card.Card;
import bigTwo.CardPattern.Pair;

public class PairHandler extends CardHandler<Pair> {

	public PairHandler(CardHandler<?> next) {
		super(next);
	}

	protected Pair tryCardPattern(List<Card> cards) {
		return new Pair(cards);
	}
}
