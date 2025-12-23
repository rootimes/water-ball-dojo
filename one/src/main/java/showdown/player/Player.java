package showdown.player;

import java.util.List;

import org.jetbrains.annotations.Nullable;
import showdown.card.Card;
import showdown.deck.Deck;

public abstract class Player implements Comparable<Player> {

    @Nullable
    private String name;

    private int score;

    protected HandCard handCard;

    private boolean hasUsedExchange = false;

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

    public boolean hasUsedExchange() {
        return hasUsedExchange;
    }

    public ExchangeState getExchangeState() {
        return exchangeState;
    }

    public void startExchange(Player other, int rounds) {
        this.exchangeState = new ExchangeState(this, other, rounds);
        other.exchangeState = this.exchangeState;
        this.hasUsedExchange = true;
        
        this.exchange(other);
    }

    public void updateExchangeState() {
        if (this.exchangeState != null && this.exchangeState.isPlayerA(this)) {
            this.exchangeState.decrementRound();
            if (this.exchangeState.isExpired()) {
                Player other = this.exchangeState.getOtherPlayer(this);
                this.exchange(other);
                other.exchangeState = null;
                this.exchangeState = null;
            }
        }
    }

    public abstract Card takeTurn(List<Player> candidates);

    protected abstract Card showCard();

    protected abstract boolean canExchange(List<Player> candidates);

    protected void exchange(Player other) {
        HandCard temp = this.handCard;
        this.handCard = other.handCard;
        other.handCard = temp;
    }

    public int compareTo(Player other) {
        return Integer.compare(this.score, other.score);
    }
}
