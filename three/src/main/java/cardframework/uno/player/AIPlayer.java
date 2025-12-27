package cardframework.uno.player;

import java.util.Random;

import cardframework.uno.card.Card;

public class AIPlayer extends Player {
    private final Random random = new Random();

    public Card takeTurn() {
        int handCardCount = this.handCard.size();
        int chosenIndex = random.nextInt(handCardCount);

        return showCard(chosenIndex);
    }

    @Override
    protected Card showCard(int index) {
        return this.handCard.remove(index);
    }
}
