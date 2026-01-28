package bigTwo.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
  private List<Card> cards = new ArrayList<>();

  public Deck() {
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        cards.add(new Card(rank, suit));
      }
    }
  }

  public Deck(String deckString) {
    String[] cardStrings = deckString.trim().split("\\s+");
    for (String cardStr : cardStrings) {
      int bracketStart = cardStr.indexOf('[');
      int bracketEnd = cardStr.indexOf(']');
      String suitCode = cardStr.substring(0, bracketStart);
      String rankSymbol = cardStr.substring(bracketStart + 1, bracketEnd);

      Suit suit = Suit.fromCode(suitCode);
      Rank rank = Rank.fromSymbol(rankSymbol);
      cards.add(new Card(rank, suit));
    }
  }

  public void shuffle() {
    Collections.shuffle(cards);
  }

  public Card deal() {
    if (!cards.isEmpty()) {
      return cards.remove(cards.size() - 1);
    }

    return null;
  }

  public boolean hasCards() {
    return !cards.isEmpty();
  }
}
