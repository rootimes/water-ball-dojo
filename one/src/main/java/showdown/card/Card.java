package showdown.card;

public class Card {
    private Rank rank;
    private Suit suit;
    
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int compareSuitTo(Card other) {
        return Integer.compare(this.suit.getValue(), other.suit.getValue());
    }

    public int compareRankTo(Card other) {
        return Integer.compare(this.rank.getValue(), other.rank.getValue());
    }
    
    public Rank getRank() {
        return rank;
    }
    
    public Suit getSuit() {
        return suit;
    }
}