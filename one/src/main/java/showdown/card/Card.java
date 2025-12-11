package showdown.card;

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

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}