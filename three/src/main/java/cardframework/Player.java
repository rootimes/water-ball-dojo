package cardframework;

import org.jetbrains.annotations.Nullable;

public abstract class Player {

    @Nullable
    protected String name;

    protected HandCard<?> handCard;

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

    protected abstract HandCard<?> createHandCard();
}