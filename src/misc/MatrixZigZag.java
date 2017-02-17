package misc;

/**
 * Created by jli on 1/4/16.
 */

//[1,2,3,3]
//[4,5,6,6]
//[7,8,9,9]
//
//0 0
//0 1 1 0
//2 0 1 1 0 2

public class MatrixZigZag {
    public int[] traversal(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int[] rst = new int[(m + 1) * (n + 1)];
        int index = 0;
        for (int i = 0; i <= m + n; i++) {
            if (i % 2 == 0) {
                for (int j = i; j >=0; j--) {
                    if (i <= m && i - j <= n) {
                        rst[index++] = matrix[j][i - j];
                    }
                }
            } else {
                for (int j = 0; j < i; j++) {
                    if (i <=m && i - j <= n) {
                        rst[index++] = matrix[j][i - j];
                    }
                }
            }

        }


        return rst;
    }
}
