package DP;

/**
 * Created by jli on 4/5/16.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int h = grid.length;
        int w = grid[0].length;
        if (h == 0 || w == 0) {
            return 0;
        }

        int[][] rst = new int[h][w];
        rst[0][0] = grid[0][0];

        for (int i = 1; i < h; i++) {
            rst[i][0] = rst[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < w; i++) {
            rst[0][i] = rst[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                rst[i][j] = Math.min(rst[i - 1][j], rst[i][j - 1]) + grid[i][j];
            }
        }

        return rst[h - 1][w - 1];
    }
}
