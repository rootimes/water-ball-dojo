package cardframework.uno;

import java.util.List;

import cardframework.uno.card.Card;
import cardframework.uno.deck.Deck;
import cardframework.uno.player.AIPlayer;
import cardframework.uno.player.HumanPlayer;
import cardframework.uno.player.Player;
import cardframework.uno.table.Table;

public class Uno extends cardframework.core.Game<Card, Player> {

    protected Table table = new Table();

    public Uno() {
        this.MAX_PLAYERS = 4;
        this.CARDS_PER_PLAYER = 5;
    }

    @Override
    protected Player createHumanPlayer() {
        return new HumanPlayer();
    }

    @Override
    protected Player createAIPlayer() {
        return new AIPlayer();
    }

    @Override
    protected Deck setDeck() {
        return new Deck();
    }

    @Override
    protected boolean isHumanPlayer(Player player) {
        return player instanceof HumanPlayer;
    }

    @Override
    protected void beforeRound() {
        Card topCard = deck.draw();
        table.setTopCard(topCard);
    }

    @Override
    protected void playRound() {
        for (Player player : players) {
            System.out.println("Top card on table: " + table.getTopCardAsString());
            System.out.println("Player " + player.getName() + "'s turn.");

            List<Card> playableCards = player.getPlayableCards(table.getTopCard());

            if (playableCards.isEmpty()) {
                System.out.println("No playable cards. Drawing a card from deck...");

                if (deck.size() == 0) {
                    System.out.println("Deck is empty. Refreshing deck from played cards...");
                    List<Card> refreshedCards = table.refresh();
                    deck.addCards(refreshedCards);
                    deck.shuffle();
                }

                player.drawCard(deck);
                continue;
            }

            Card playedCard = player.takeTurn();

            if (player.handCardIsEmpty()) {
                this.finalWinner = player;
                break;
            }

            table.swapTopCard(playedCard);
        }

        if (!isGameOver()) {
            playRound();
        }
    }

    @Override
    protected boolean isGameOver() {
        return finalWinner != null;
    }
}
