package bigTwo.Card;

public class Card {

	private Rank rank;
	private Suit suit;

	public Card(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public boolean isClub3() {
		return this.rank == Rank.THREE && this.suit == Suit.CLUB;
	}

	public int getRankValue() {
		return this.rank.getValue();
	}

	public int getSuitValue() {
		return this.suit.getValue();
	}

	public int compareTo(Card other) {
		int rankCmp = Integer.compare(this.getRankValue(), other.getRankValue());
		if (rankCmp != 0) {
			return rankCmp;
		}
		return Integer.compare(this.getSuitValue(), other.getSuitValue());
	}

	public String toString() {
		return suit.getCode() + "[" + rank.getSymbol() + "]";
	}
}
