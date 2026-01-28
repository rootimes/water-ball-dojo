package bigTwo.cardhandler;

import bigTwo.card.Card;
import bigTwo.cardpattern.Single;
import java.util.List;

public class SingleHandler extends CardHandler<Single> {

  public SingleHandler(CardHandler<?> next) {
    super(next);
  }

  protected Single tryCardPattern(List<Card> cards) {
    return new Single(cards);
  }
}
