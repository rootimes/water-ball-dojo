package bigTwo.player;

import java.util.List;
import java.util.ArrayList;

import bigTwo.Card.Card;

public abstract class Player {
    private String name;

    private HandCard handCard;

    public Player() {
        this.handCard = new HandCard();
    }

    public void name(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract List<Card> play();

    public abstract void pass();

    public List<Card> getCardsByString(String input) {
        String[] parts = input.split(" ");
        List<Card> selectedCards = new ArrayList<>();
        for (String part : parts) {
            int index = Integer.parseInt(part.trim());
            selectedCards.add(handCard.getCard(index));
        }
        return selectedCards;
    }

    public void addCard(Card card) {
        handCard.add(card);
    }
    
    public boolean removeCards(List<Card> cards) {
        return handCard.removeCards(cards);
    }
}
