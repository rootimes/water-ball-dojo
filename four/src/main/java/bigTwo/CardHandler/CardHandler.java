package bigTwo.CardHandler;

import java.util.List;

import bigTwo.Card.Card;
import bigTwo.CardPattern.CardPattern;

public abstract class CardHandler<P extends CardPattern<P>> {

	protected CardHandler<?> next;

	public CardHandler(CardHandler<?> next) {
		this.next = next;
	}

	public CardPattern<?> handle(List<Card> cards) {

		P pattern = tryCardPattern(cards);

		if (pattern.validate(cards)) {
			return pattern;
		} else if (next != null) {
			return next.handle(cards);
		}

		return null;
	}

	protected abstract P tryCardPattern(List<Card> cards);
}
