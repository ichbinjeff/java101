package DP;

/**
 * Created by jli on 4/5/16.
 */
public class UniquePath {
    public int uniquePath(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] rst = new int[m][n];
        for (int i = 0; i < m; i++) {
            rst[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            rst[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                rst[i][j] = rst[i - 1][j] + rst[i][j - 1] + 1;
            }
        }

        return rst[m - 1][n - 1];

    }

    public int uniquePathWithBlock(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }

        int h = obstacleGrid.length;
        int w = obstacleGrid[0].length;
        if (w == 0 || h == 0) {
            return 0;
        }
        int[][] rst = new int[h][w];
        for (int i = 0; i < h; i++) {
            if(obstacleGrid[i][0] != 1) {
                rst[i][0] = 1;
            } else {
                break;
            }
        }

        for (int i = 0; i < w; i++) {
            if(obstacleGrid[0][i] != 1) {
                rst[0][i] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                if(obstacleGrid[i][j] == 1) {
                    rst[i][j] = 0;
                } else {
                    rst[i][j] = rst[i - 1][j] + rst[i][j - 1];
                }
            }
        }

        return rst[h - 1][w - 1];
    }


}
