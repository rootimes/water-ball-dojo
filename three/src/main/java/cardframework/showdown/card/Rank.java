package cardframework.showdown.card;

public enum Rank {
	TWO(0, "2"), THREE(1, "3"), FOUR(2, "4"), FIVE(3, "5"), SIX(4, "6"), SEVEN(5, "7"), EIGHT(6, "8"), NINE(7,
			"9"), TEN(8, "10"), JACK(9, "J"), QUEEN(10, "Q"), KING(11, "K"), ACE(12, "A");

	private final int value;
	private final String symbol;

	Rank(int value, String symbol) {
		this.value = value;
		this.symbol = symbol;
	}

	public int getValue() {
		return value;
	}

	public String getSymbol() {
		return symbol;
	}
}
