package OO;

import java.util.ArrayList;

/**
 * Created by jli on 12/2/15.
 */
public class Deck <T extends Card> {
    private ArrayList<T> cards;
    private int dealtIndex = 0;

    public void setDeckOfCards(ArrayList<T> deckOfCards) {
    }

    public void shuffle() {}

    public int remainingCards() {
        return cards.size() - dealtIndex;
    }
//
//    public T[] dealHand(int number) {
//
//    }
//
//    public T dealCard() {}

}
