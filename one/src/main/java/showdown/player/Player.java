package showdown.player;

import showdown.card.Card;
import java.util.List;
import java.util.ArrayList;

public abstract class Player {

    protected String name;
    protected List<Card> hand;
    
    public Player() {
        this.hand = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<Card> getHand() {
        return hand;
    }
    
    public void addCard(Card card) {
        hand.add(card);
    }
    
    public abstract List<Card> exchangeHand();
}
