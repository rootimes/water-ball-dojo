package bigTwo.cardhandler;

import bigTwo.card.Card;
import bigTwo.cardpattern.CardPattern;
import java.util.List;

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
