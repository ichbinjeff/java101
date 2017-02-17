/**
 * Created by jli on 10/26/15.
 */
// m rows, n cols
//    [1,2,3]
//    [4,5,6]
//    [7,8,9]

public class UniquePath {
    public int search(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        int [][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {
            sum[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            sum[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
            }
        }

        return sum[m - 1][n - 1];
    }
}
