package cardframework;

import org.jetbrains.annotations.Nullable;

public abstract class Player<T extends Card> {

    @Nullable
    protected String name;

    protected HandCard<T> handCard;

    public Player() {
        this.name = null;
        this.handCard = createHandCard();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract T takeTurn();

    protected abstract T showCard(int index);

    protected abstract HandCard<T> createHandCard();
}