package cardframework.showdown.player;

import cardframework.showdown.card.Card;

public abstract class Player extends cardframework.Player<Card> {
    @Override
    protected HandCard createHandCard() {
        return new HandCard();
    }

    public abstract Card takeTurn();
}
