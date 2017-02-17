package NineChapter.DP;

/**
 * Created by shli15 on 6/22/16.
 */
public class UniquePathWithObstacle {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int h = obstacleGrid.length;
        int w = obstacleGrid[0].length;

        int[][] f = new int[h][w];
        for (int i = 0; i < h; i++) {
            if (obstacleGrid[i][0] != 1) {
                f[i][0] = 1;
            } else {
                break;
            }
        }

        for (int j = 0; j < w; j++) {
            if (obstacleGrid[0][j] != 1) {
                f[0][j] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                if (obstacleGrid[i][j] == 0) {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                } else {
                    f[i][j] = 0;
                }
            }
        }

        return f[h - 1][w - 1];
    }
}
