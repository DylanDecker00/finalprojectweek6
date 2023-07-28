package WarGame;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand;
    private int score;
    private String name;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.hand = new ArrayList<>();
    }

    // Describe method
    public void describe() {
        System.out.println("Player: " + name);
        for (Card card : hand) {
            card.describe();
        }
    }

    // Flip method
    public Card flip() {
        if (hand.isEmpty()) {
            return null;
        }
        return hand.remove(0);
    }

    // Draw method
    public void draw(Deck deck) {
        Card card = deck.draw();
        if (card != null) {
            hand.add(card);
        }
    }

    // IncrementScore method
    public void incrementScore() {
        score++;
    }

    // Getters and Setters
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
