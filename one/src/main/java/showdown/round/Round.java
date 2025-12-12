package showdown.round;

import java.util.Map;

import showdown.card.Card;
import showdown.player.Player;

public class Round {
    private final int roundNumber;

    private Map<Player, Card> roundPlayers;

    public Round(Map<Player, Card> roundPlayers, int roundNumber) {
        this.roundPlayers = roundPlayers;
        this.roundNumber = roundNumber;
    }

    public StringBuilder displayRoundCards() {
        StringBuilder sb = new StringBuilder();
        sb.append("第 ").append(roundNumber).append(" 回合玩家出牌情況:\n");
        for (Map.Entry<Player, Card> entry : roundPlayers.entrySet()) {
            Player player = entry.getKey();
            Card card = entry.getValue();
            sb.append(player.getName())
                    .append(" 出了 ")
                    .append(card.getSuit())
                    .append(":")
                    .append(card.getRank())
                    .append("\n");
        }
        return sb;
    }

    public Map.Entry<Player, Card> compare() {

        Card maxCard = null;
        Player winner = null;

        for (Map.Entry<Player, Card> entry : roundPlayers.entrySet()) {
            Card card = entry.getValue();
            if (maxCard == null || card.compareTo(maxCard) > 0) {
                maxCard = card;
                winner = entry.getKey();
            }
        }

        return Map.entry(winner, maxCard);
    }
}
