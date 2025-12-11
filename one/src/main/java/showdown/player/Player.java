package showdown.player;

import showdown.card.Card;
import java.util.List;
import java.util.ArrayList;

public abstract class Player {

    protected String name;
    protected int score;
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

    public void addScore(int points) {
        this.score += points;
    }

    public int getScore() {
        return score;
    }

    public StringBuilder displayCards() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" 的手牌:\n");

        hand.sort(Card::compareTo);

        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.get(i);
            sb.append(i).append(" - ").append(card.getSuit()).append(":")
                    .append(card.getRank())
                    .append("\n");
        }

        return sb;
    }

    public void exchangeHand(Player player) {
        List<Card> tmp = new ArrayList<>(this.hand);
        this.hand = new ArrayList<>(player.hand);
        player.hand = new ArrayList<>(tmp);
    }

    public Card showCard(int index) {
        if (index >= 0 && index < hand.size()) {
            Card playedCard = hand.remove(index);
            return playedCard;
        } else {
            return null;
        }
    }
}
