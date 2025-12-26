package cardframework.showdown.card;

public class Card implements Comparable<Card> {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public int compareTo(Card other) {
        int rankComparison = Integer.compare(this.rank.getValue(), other.rank.getValue());
        if (rankComparison != 0) {
            return rankComparison;
        }
        return Integer.compare(this.suit.getValue(), other.suit.getValue());
    }

    public String getRankSymbol() {
        return rank.getSymbol();
    }

    public String getSuitSymbol() {
        return suit.getSymbol();
    }

    public String toString() {
        return suit.getSymbol() + ": " + rank.getSymbol();
    }
}