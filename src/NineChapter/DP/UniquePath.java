package NineChapter.DP;

/**
 * Created by shli15 on 6/21/16.
 */
public class UniquePath {
    public int uniquePaths(int m, int n) {
        // 错误code1
//        int[][] f = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            f[i][0] = 1;
//            f[0][i] = 1;
//        }
//
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                f[i][j] = f[i - 1][j] + f[i][j - 1] + 1;
//            }
//        }
//
//        return f[m - 1][n - 1];

        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            f[0][j] = 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }

        return f[m - 1][n - 1];
    }
}
