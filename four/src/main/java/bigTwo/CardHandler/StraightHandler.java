package bigTwo.CardHandler;

import java.util.List;

import bigTwo.Card.Card;
import bigTwo.CardPattern.Straight;

public class StraightHandler extends CardHandler<Straight> {

	public StraightHandler(CardHandler<?> next) {
		super(next);
	}

	protected Straight tryCardPattern(List<Card> cards) {
		return new Straight(cards);
	}
}
