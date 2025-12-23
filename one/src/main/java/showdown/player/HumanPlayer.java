package showdown.player;

import java.util.List;
import java.util.Scanner;

import showdown.card.Card;

public class HumanPlayer extends Player {

    Scanner scanner = new Scanner(System.in);

    public Card takeTurn(List<Player> candidates) {
        if (canExchange(candidates)) {
            System.out.println(getName() + "，你想要交換牌嗎？(y/n)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("y")) {
                System.out.println("可交換的玩家：");
                for (int i = 0; i < candidates.size(); i++) {
                    System.out.println((i + 1) + ". " + candidates.get(i).getName());
                }
                System.out.println("請輸入你想交換的玩家編號：");
                int choice = Integer.parseInt(scanner.nextLine()) - 1;
                if (choice >= 0 && choice < candidates.size()) {
                    Player selectedPlayer = candidates.get(choice);
                    this.startExchange(selectedPlayer, 3);
                    System.out.println(getName() + " 與 " + selectedPlayer.getName() + " 交換了牌！");
                } else {
                    System.out.println("無效的選擇，跳過交換。");
                }
            } else {
                System.out.println(getName() + " 選擇不交換牌。");
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
        System.out.println(getName() + "，請選擇你要出的牌：");
        for (int i = 0; i < handCard.size(); i++) {
            Card card = handCard.get(i);
            System.out.println((i + 1) + ". " + card.toString());
        }
        int choice = Integer.parseInt(scanner.nextLine()) - 1;
        if (choice >= 0 && choice < handCard.size()) {
            Card selectedCard = handCard.remove(choice);
            System.out.println(getName() + " 出了 " + selectedCard.toString());
            return selectedCard;
        } else {
            System.out.println("無效的選擇，請重新選擇。");
            return showCard();
        }
    }
}