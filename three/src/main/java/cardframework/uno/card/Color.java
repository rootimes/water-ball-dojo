package cardframework.uno.card;

public enum Color {
  BLUE(0, "B"),
  RED(1, "R"),
  YELLOW(2, "Y"),
  GREEN(3, "G");

  private final int value;
  private final String symbol;

  Color(int value, String symbol) {
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
