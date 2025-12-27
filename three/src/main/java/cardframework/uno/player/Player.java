package cardframework.uno.player;

import cardframework.uno.card.Card;

public abstract class Player extends cardframework.Player<Card> {
    @Override
    protected HandCard createHandCard() {
        return new HandCard();
    }
}
