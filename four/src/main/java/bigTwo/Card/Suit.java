package bigTwo.Card;

public enum Suit {
    CLUBS(0, "梅花"), DIAMONDS(1, "菱形"),
    HEARTS(2, "愛心"), SPADES(3, "黑桃");

    private final int value;
    private final String symbol;

    Suit(int value, String symbol) {
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