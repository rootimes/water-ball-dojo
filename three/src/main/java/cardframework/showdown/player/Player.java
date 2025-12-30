package cardframework.showdown.player;

import cardframework.showdown.card.Card;

public abstract class Player extends cardframework.core.Player<Card> {

	protected int score = 0;

	public int getScore() {
		return score;
	}

	public void addScore(int points) {
		this.score += points;
	}

	@Override
	protected HandCard createHandCard() {
		return new HandCard();
	}

	public abstract Card takeTurn();
}
