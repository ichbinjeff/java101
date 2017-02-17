package NineChapter.DP;

/**
 * Created by shli15 on 6/22/16.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        /* 错误答案
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int w = grid.length;
        int h = grid[0].length;

        int[][] f = new int[w][h];

        for (int i = 0; i < w; i++) {
            f[i][0] = grid[i][0];
        }

        for (int j = 0; j < h; j++) {
            f[0][j] = grid[0][j];
        }

        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }

        return f[h - 1][w - 1];

        // 错误答案2
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int w = grid.length;
        int h = grid[0].length;

        int[][] f = new int[w][h];
        f[0][0] = grid[0][0];
        for (int i = 1; i < w; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < h; j++) {
            f[0][j] = f[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }

        return f[h - 1][w - 1];
        */

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int h = grid.length;
        int w = grid[0].length;

        int[][] f = new int[h][w];
        f[0][0] = grid[0][0];
        for (int i = 1; i < h; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < w; j++) {
            f[0][j] = f[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }

        return f[h - 1][w - 1];
    }
}
