package showdown.player;

import showdown.card.Card;
import java.util.List;
import java.util.ArrayList;

public abstract class Player {

    private String name;
    private int score;
    private List<Card> handCards;

    public Player() {
        this.handCards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getHandCards() {
        return handCards;
    }

    public void addCard(Card card) {
        handCards.add(card);
    }

    public void addScore(int points) {
        this.score += points;
    }

    public boolean hasCards() {
        return !handCards.isEmpty();
    }

    public StringBuilder displayCards() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" 的手牌:\n");

        handCards.sort(Card::compareTo);

        for (int i = 0; i < handCards.size(); i++) {
            Card card = handCards.get(i);
            sb.append(i).append(" - ").append(card.getSuit()).append(":")
                    .append(card.getRank())
                    .append("\n");
        }

        return sb;
    }

    public void exchangeHandCards(Player player) {
        List<Card> tmp = new ArrayList<>(this.handCards);
        this.handCards = new ArrayList<>(player.handCards);
        player.handCards = new ArrayList<>(tmp);
    }

    public Card showCard(int index) {
        if (index >= 0 && index < handCards.size()) {
            Card playedCard = handCards.remove(index);
            return playedCard;
        } else {
            return null;
        }
    }
}
