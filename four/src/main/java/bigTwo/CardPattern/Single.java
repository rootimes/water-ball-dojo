package bigTwo.cardpattern;

import bigTwo.card.Card;
import java.util.List;

public class Single extends CardPattern<Single> {

  public Single(List<Card> cards) {
    this.size = 1;
    this.name = "單張";
    this.cards = cards;
  }

  @Override
  protected int compareToSameType(Single other) {
    Card a = this.getCard(0);
    Card b = other.getCard(0);

    int rankCmp = Integer.compare(a.getRankValue(), b.getRankValue());
    if (rankCmp != 0) {
      return rankCmp;
    }

    return Integer.compare(a.getSuitValue(), b.getSuitValue());
  }

  @Override
  public boolean validate(List<Card> cards) {
    return isValidSize(cards);
  }
}
