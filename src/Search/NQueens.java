package Search;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by shli15 on 6/14/16.
 */
public class NQueens {
    public int solutions = 0;
    public int totalNQueens(int n) {
        //write your code here
        List<Integer> cols = new ArrayList<Integer>();
        dfs(n, cols);
        return solutions;
    }

    public void dfs(int n, List<Integer> cols) {
        if (cols.size() == n) {
            solutions ++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isValid(cols, i)) {
                continue;
            }

            cols.add(i);
            dfs(n, cols);
            cols.remove(cols.size() - 1);
        }
    }

    public boolean isValid(List<Integer> cols, int col) {
        for (int i = 0; i < cols.size(); i++) {
            if (cols.get(i) + i == col + cols.size()) {
                return false;
            }

            if (cols.get(i) == col) {
                return false;
            }

            if (Math.abs(cols.get(i) - i) == Math.abs(cols.size() - col)) {
                return false;
            }
        }
        return true;

        // 1 1 1  2,3,1
        // 1 1 1
        // 1 1 1
    }

    public static void main(String[] args) {
        NQueens nq = new NQueens();
        nq.totalNQueens(4);
    }
}
