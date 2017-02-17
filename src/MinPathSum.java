/**
 * Created by jli on 10/26/15.
 */
// m rows, n cols
//    [1,2,3]
//    [4,5,6]
//    [7,8,9]

//    f[i][j]
//    f[i - 1][j]
//    f[i][j - 1]

public class MinPathSum {
    public static int search(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        if (grid[0] == null || grid.length == 0) {
            return 0;
        }

        int r = grid.length;
        int c = grid[0].length;
        int[][] sum = new int[r][c];
        sum[0][0] = grid[0][0];

        for (int i = 1; i < r; i++) {
            sum[i][0] = grid[i][0] + sum[i - 1][0];
        }

        for (int j = 1; j < c; j++) {
            sum[0][j] = grid[0][j] + grid[0][j - 1];
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                sum[i][j] = Math.min(sum[i - 1][j], sum[i][j - 1]) + grid[i][j];
            }
        }

        int best = sum[r - 1][c - 1];
        for (int i = 1; i < c; i++) {
            best = Math.min(best, sum[r - 1][i]);
        }

        return best;
    }
}
