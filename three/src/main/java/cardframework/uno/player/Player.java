package cardframework.uno.player;

import java.util.List;

import cardframework.uno.card.Card;

public abstract class Player extends cardframework.core.Player<Card> {
  @Override
  protected HandCard createHandCard() {
    return new HandCard();
  }

  public List<Card> getPlayableCards(Card topCard) {
    List<Card> hanCards = this.handCard.getAllCards();

    return hanCards.stream().filter(card -> card.match(topCard)).toList();
  }

  public boolean handCardIsEmpty() {
    return handCard.size() == 0;
  }

  public abstract Card takeTurn();
}
