package bigTwo.player;

import bigTwo.card.Card;
import java.util.List;

public abstract class Player {
  protected String name;

  protected HandCard handCard;

  public Player() {
    this.handCard = new HandCard();
  }

  public void name(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public abstract List<Card> play(String input);

  public String showHandCards() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < handCard.size(); i++) {
      Card card = handCard.getCard(i);
      sb.append(card.toString());
      sb.append(" ");
    }
    return sb.toString().trim();
  }

  public String showHandCardIndexes() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < handCard.size(); i++) {
      Card card = handCard.getCard(i);
      int cardWidth = card.toString().length();
      sb.append(String.format("%-" + cardWidth + "d", i));
      sb.append(" ");
    }
    return sb.toString().trim();
  }

  public Card getHandCard(int index) {
    return handCard.getCard(index);
  }

  public int getHandCardSize() {
    return handCard.size();
  }

  public void sortHandCards() {
    handCard.sort();
  }

  public void addCard(Card card) {
    handCard.add(card);
  }

  public boolean removeCards(List<Card> cards) {
    return handCard.removeCards(cards);
  }
}
