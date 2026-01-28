package bigTwo.cardhandler;

import java.util.List;

import bigTwo.card.Card;
import bigTwo.cardpattern.Straight;

public class StraightHandler extends CardHandler<Straight> {

	public StraightHandler(CardHandler<?> next) {
		super(next);
	}

	protected Straight tryCardPattern(List<Card> cards) {
		return new Straight(cards);
	}
}
