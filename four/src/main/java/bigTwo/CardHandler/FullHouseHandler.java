package bigTwo.cardhandler;

import java.util.List;

import bigTwo.card.Card;
import bigTwo.cardpattern.FullHouse;

public class FullHouseHandler extends CardHandler<FullHouse> {

	public FullHouseHandler(CardHandler<?> next) {
		super(next);
	}

	protected FullHouse tryCardPattern(List<Card> cards) {
		return new FullHouse(cards);
	}
}
