package bigTwo.CardHandler;

import java.util.List;

import bigTwo.Card.Card;
import bigTwo.CardPattern.FullHouse;

public class FullHouseHandler extends CardHandler<FullHouse> {

	public FullHouseHandler(CardHandler<?> next) {
		super(next);
	}

	protected FullHouse tryCardPattern(List<Card> cards) {
		return new FullHouse(cards);
	}

}
