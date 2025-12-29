package cardframework.uno.deck;

import cardframework.uno.card.Card;
import cardframework.uno.card.Color;
import cardframework.uno.card.Number;

public class Deck extends cardframework.core.Deck<Card> {

  public Deck() {
    for (Color color : Color.values()) {
      for (Number value : Number.values()) {
        cards.add(new Card(color, value));
      }
    }
  }
}
