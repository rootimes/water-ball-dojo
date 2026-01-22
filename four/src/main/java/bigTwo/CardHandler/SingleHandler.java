package bigTwo.cardhandler;

import java.util.List;

import bigTwo.card.Card;
import bigTwo.cardpattern.Single;

public class SingleHandler extends CardHandler<Single> {

	public SingleHandler(CardHandler<?> next) {
		super(next);
	}

	protected Single tryCardPattern(List<Card> cards) {
		return new Single(cards);
	}
}