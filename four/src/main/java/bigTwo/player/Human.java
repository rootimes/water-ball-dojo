package bigTwo.player;

import bigTwo.card.Card;
import java.util.ArrayList;
import java.util.List;

public class Human extends Player {

  public List<Card> play(String input) {
    String[] parts = input.split(" ");
    List<Card> selectedCards = new ArrayList<>();
    for (String part : parts) {
      int index = Integer.parseInt(part.trim());
      selectedCards.add(handCard.getCard(index));
    }
    return selectedCards;
  }
}
