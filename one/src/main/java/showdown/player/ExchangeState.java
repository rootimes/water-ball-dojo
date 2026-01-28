package showdown.player;

public class ExchangeState {

	private int remainingRounds;
	private Player playerA;
	private Player playerB;

	public ExchangeState(Player playerA, Player playerB, int rounds) {
		this.playerA = playerA;
		this.playerB = playerB;
		this.remainingRounds = rounds;
	}

	public Player getOtherPlayer(Player self) {
		return self == playerA ? playerB : playerA;
	}

	public boolean isPlayerA(Player player) {
		return player == playerA;
	}

	public void decrementRound() {
		this.remainingRounds--;
	}

	public boolean isExpired() {
		return this.remainingRounds <= 0;
	}
}
