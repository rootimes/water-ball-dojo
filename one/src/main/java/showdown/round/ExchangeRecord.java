package showdown.round;

import showdown.player.Player;

public class ExchangeRecord {
    Player player1;
    Player player2;
    int roundsLeft;

    public ExchangeRecord(Player player1, Player player2, int roundsLeft) {
        this.player1 = player1;
        this.player2 = player2;
        this.roundsLeft = roundsLeft;
    }

    public int getRoundsLeft() {
        return roundsLeft;
    }

    public int decreaseRoundsLeft() {
        return --roundsLeft;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
