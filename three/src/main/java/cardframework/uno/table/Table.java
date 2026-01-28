package cardframework.uno.table;

import java.util.ArrayList;
import java.util.List;

import cardframework.uno.card.Card;

public class Table {

  private Card topCard;

  private List<Card> playedCards = new ArrayList<>();

  public Card getTopCard() {
    return topCard;
  }

  public String getTopCardAsString() {
    return topCard.toString();
  }

  public void setTopCard(Card topCard) {
    this.topCard = topCard;
  }

  public void swapTopCard(Card card) {
    playedCards.add(topCard);
    topCard = card;
  }

  public List<Card> refresh() {
    List<Card> cards = new ArrayList<>(playedCards);
    playedCards.clear();
    return cards;
  }
}
