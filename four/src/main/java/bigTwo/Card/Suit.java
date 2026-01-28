package bigTwo.card;

public enum Suit {
	CLUB(0, "梅花", "C"), DIAMOND(1, "菱形", "D"), HEART(2, "愛心", "H"), SPADE(3, "黑桃", "S");

	private final int value;
	private final String symbol;
	private final String code;

	Suit(int value, String symbol, String code) {
		this.value = value;
		this.symbol = symbol;
		this.code = code;
	}

	public int getValue() {
		return value;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getCode() {
		return code;
	}

	public static Suit fromCode(String code) {
		for (Suit suit : values()) {
			if (suit.code.equals(code)) {
				return suit;
			}
		}
		throw new IllegalArgumentException("Unknown suit code: " + code);
	}
}
