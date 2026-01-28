package bigTwo.cardhandler;

import bigTwo.card.Card;
import bigTwo.cardpattern.Straight;
import java.util.List;

public class StraightHandler extends CardHandler<Straight> {

  public StraightHandler(CardHandler<?> next) {
    super(next);
  }

  protected Straight tryCardPattern(List<Card> cards) {
    return new Straight(cards);
  }
}
