package bigTwo.CardHandler;

import java.util.List;

import bigTwo.Card.Card;
import bigTwo.CardPattern.Single;

public class SingleHandler extends CardHandler<Single> {

	public SingleHandler(CardHandler<?> next) {
		super(next);
	}

	protected Single tryCardPattern(List<Card> cards) {
		return new Single(cards);
	}
}