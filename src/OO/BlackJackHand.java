package OO;
import java.util.ArrayList;

/**
 * Created by jli on 12/2/15.
 */
public class BlackJackHand extends Hand<BlackJackCard> {
    public int score() {
        ArrayList<Integer> scores = possibleScores();
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;
        for (int score : scores) {
            if (score > 21 && score < minOver) {
                minOver = score;
            } else if (score <= 21 && score > maxUnder) {
                maxUnder = score;
            }
        }
        return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
    }

    public ArrayList<Integer> possibleScores() {
        return new ArrayList<Integer>();
    }

    public boolean busted() { return score() > 21; }

    public boolean is21() { return score() == 21; }

    public boolean isBlackJack() {
        if (!is21()) return false;
        if (cards.size() != 2) return false;
        for (Card c : cards) {
            if (c.value() != 10 || c.value() != 11) {
                return false;
            }
        }

        return true;
    }
}
