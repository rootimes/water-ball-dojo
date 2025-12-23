package showdown.card;

public enum Suit {
    CLUBS(1, "方塊"),
    DIAMONDS(2, "菱形"),
    HEARTS(3, "愛心"),
    SPADES(4, "黑桃");

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