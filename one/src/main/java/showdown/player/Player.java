package showdown.player;

import java.util.List;

import org.jetbrains.annotations.Nullable;
import showdown.card.Card;
import showdown.deck.Deck;

public abstract class Player {

    @Nullable
    private String name;

    private int score;

    protected HandCard handCard;

    @Nullable
    private ExchangeState exchangeState;

    public Player() {
        this.handCard = new HandCard();

        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int point) {
        this.score += point;
    }

    public void drawCard(Deck deck) {
        Card card = deck.draw();
        this.handCard.add(card);
    }

    public HandCard getHandCard() {
        return handCard;
    }

    public ExchangeState getExchangeState() {
        return exchangeState;
    }

    public abstract Card takeTurn(List<Player> candidates);

    protected abstract Card showCard();

    protected abstract boolean canExchange(List<Player> candidates);

    protected void exchange(Player other) {
        if (this.exchangeState != null || other.exchangeState != null) {
            throw new IllegalStateException("One of the players is already in exchange state.");
        }

        HandCard temp = this.handCard;
        this.handCard = other.handCard;
        other.handCard = temp;

        this.exchangeState = new ExchangeState(3);
        other.exchangeState = new ExchangeState(3);
    }
}
