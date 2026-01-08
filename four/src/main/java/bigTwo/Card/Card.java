package bigTwo.Card;

public class Card {

    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRankValue() {
        return this.rank.getValue();
    }

    public int getSuitValue() {
        return this.suit.getValue();
    }

    public String toString() {
        return suit.getSymbol() + ": " + rank.getSymbol();
    }
}
