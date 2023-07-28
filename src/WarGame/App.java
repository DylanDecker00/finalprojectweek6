package WarGame;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Instantiate a Deck and two Players
        Deck deck = new Deck();
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // Shuffle the deck
        deck.shuffle();

        // Deal cards to players
        for (int i = 0; i < 52; i++) {
            player1.draw(deck);
            player2.draw(deck);
        }

        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Play the game
        for (int i = 0; i < 26; i++) {
            System.out.println("Turn " + (i + 1));
            scanner.nextLine(); // Wait for user to press "Enter"

            Card player1Card = player1.flip();
            Card player2Card = player2.flip();

            System.out.println(player1.getName() + " flipped: ");
            player1Card.describe();

            System.out.println(player2.getName() + " flipped: ");
            player2Card.describe();

            // Compare the values of the cards and update scores
            if (player1Card.getValue() > player2Card.getValue()) {
                player1.incrementScore();
                System.out.println(player1.getName() + " wins this turn!\n");
            } else if (player1Card.getValue() < player2Card.getValue()) {
                player2.incrementScore();
                System.out.println(player2.getName() + " wins this turn!\n");
            } else {
                System.out.println("It's a tie!\n");
            }
        }

        // Close the scanner after the game ends
        scanner.close();

        // Print the final score
        System.out.println("Final score:");
        System.out.println(player1.getName() + ": " + player1.getScore());
        System.out.println(player2.getName() + ": " + player2.getScore());

        // Determine the winner
        if (player1.getScore() > player2.getScore()) {
            System.out.println("The winner is: " + player1.getName());
        } else if (player1.getScore() < player2.getScore()) {
            System.out.println("The winner is: " + player2.getName());
        } else {
            System.out.println("It's a draw!");
        }
    }
}