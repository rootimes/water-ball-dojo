package cardframework.uno.player;

import java.util.Scanner;

import cardframework.uno.card.Card;

public class HumanPlayer extends Player {
  private final Scanner scanner = new Scanner(System.in);

  public Card takeTurn() {
    System.out.println("Your hand:");
    for (int i = 0; i < handCard.size(); i++) {
      System.out.println(i + ": " + handCard.get(i).toString());
    }
    System.out.print("Choose a card index to play: ");
    int chosenIndex = scanner.nextInt();
    return showCard(chosenIndex);
  }

  @Override
  protected Card showCard(int index) {
    return this.handCard.remove(index);
  }
}
