package bigTwo.cardhandler;

import bigTwo.card.Card;
import bigTwo.cardpattern.Pair;
import java.util.List;

public class PairHandler extends CardHandler<Pair> {

  public PairHandler(CardHandler<?> next) {
    super(next);
  }

  protected Pair tryCardPattern(List<Card> cards) {
    return new Pair(cards);
  }
}
