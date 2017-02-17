/**
 * Created by shli15 on 12/14/16.
 */
import java.util.Set;
import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> lineset = new HashSet<Character>();
            Set<Character> colset = new HashSet<Character>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && (board[i][j] < '1' || board[i][j] > '9' || lineset.contains(board[i][j]))) {
                    return false;
                }

                if (board[j][i] != '.' && (board[j][i] < '1' || board[j][i] > '9' || colset.contains(board[j][i]))) {
                    return false;
                }
                lineset.add(board[i][j]);
                colset.add(board[j][i]);
            }
        }

        for (int span = 0; span <= board.length; span += 3) {
            Set<Character> set = new HashSet<Character>();
            for (int i = span; i < span + 3; i++) {
                for (int j = span; j < span + 3; j++) {
                    if (board[i][j] != '.' && (board[i][j] < '1' || board[i][j] > '9' || set.contains(board[i][j]))) {
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidSudoku VS = new ValidSudoku();
        char[][] tst = new char[][]{
                {'.','8','7','6','5','4','3','2','1'},
                {'2', '.', '.','.', '.','.','.','.','.'},
                {'3','.','.','.','.','.','.','.','.'},
                {'4','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','.','.'},
                {'6','.','.','.','.','.','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'8','.','.','.','.','.','.','.','.'},
                {'9','.','.','.','.','.','.','.','.'}
        };
        VS.isValidSudoku(tst);
    }
}
