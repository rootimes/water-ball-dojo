package cardframework;

import java.util.Scanner;
import cardframework.showdown.Showdown;
import cardframework.uno.Uno;

public class Main {

   public static void main(String[] args) {
      System.out.println("Select a card game to play:");

      System.out.println("1. Showdown");
      System.out.println("2. Uno");

      System.out.println("Enter your choice (1 or 2): ");
      try {
         Scanner scanner = new Scanner(System.in);
         int choice = scanner.nextInt();

         switch (choice) {
            case 1:
               Showdown showdownGame = new Showdown();
               showdownGame.setup();
               showdownGame.start();
               showdownGame.end();
               break;
            case 2:
               Uno unoGame = new Uno();
               unoGame.setup();
               unoGame.start();
               unoGame.end();
               break;
            default:
               System.out.println("Invalid choice. Please select 1 or 2.");
         }

         scanner.close();
      } catch (Exception e) {
         System.out.println("An error occurred: " + e.getMessage());
      }
   }
}
