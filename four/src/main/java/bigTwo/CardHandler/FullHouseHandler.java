package bigTwo.cardhandler;

import bigTwo.card.Card;
import bigTwo.cardpattern.FullHouse;
import java.util.List;

public class FullHouseHandler extends CardHandler<FullHouse> {

  public FullHouseHandler(CardHandler<?> next) {
    super(next);
  }

  protected FullHouse tryCardPattern(List<Card> cards) {
    return new FullHouse(cards);
  }
}
