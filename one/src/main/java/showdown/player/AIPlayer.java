package showdown.player;

import java.util.List;
import showdown.card.Card;

public class AIPlayer extends Player {

    public Card takeTurn(List<Player> candidates) {
        if (canExchange(candidates)) {
            int choice = (int) (Math.random() * (candidates.size() * 3)); // 2 / 3 機率不交換
            if (choice < candidates.size()) {
                Player selectedPlayer = candidates.get(choice);
                this.startExchange(selectedPlayer, 3);
                System.out.println(getName() + " 與 " + selectedPlayer.getName() + " 交換了牌！");
            }
        }

        return showCard();
    }

    protected boolean canExchange(List<Player> candidates) {
        return !hasUsedExchange() && !candidates.isEmpty() && getExchangeState() == null;
    }

    protected Card showCard() {
        if (handCard.size() == 0) {
            return null;
        }
        int choice = (int) (Math.random() * handCard.size());
        Card selectedCard = handCard.remove(choice);
        System.out.println(getName() + " 出了 " + selectedCard);
        return selectedCard;
    }
}