package WarGame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        populateDeck();
    }

    private void populateDeck() {
        String[] names = {"Diamonds", "Spades", "Clubs", "Hearts"};
        for (String name : names) {
            for (int value = 2; value <= 14; value++) {
                cards.add(new Card(value, name));
            }
        }
    }

    // Shuffle method
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Draw method
    public Card draw() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }
}
