package cardframework.uno.card;

public class Card extends cardframework.Card {
    private Color color;
    private Number number;

    public Card(Color color, Number number) {
        this.color = color;
        this.number = number;
    }

    public boolean match(Card other) {
        return this.color == other.color && this.number == other.number;
    }

    public String toString() {
        return color.getSymbol() + ": " + number.getSymbol();
    }
}
