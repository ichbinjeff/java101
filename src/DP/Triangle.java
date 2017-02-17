package DP;

/**
 * Created by jli on 4/5/16.
 */
//    [
//        [  2],
//        [ 3,4],
//        [6,5,7],
//        4,1,8,3]]
public class Triangle {
    public int minimumTotal(int[][] triangle) {
        if (triangle == null) {
            return -1;
        }
        int h = triangle.length;
        int w = triangle[0].length;

        if (h == 0 || w == 0) {
            return -1;
        }
        int[][] rst = new int[h][w];
        rst[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            rst[i][0] = rst[i - 1][0] + triangle[i][0];
            rst[i][i] = rst[i - 1][i - 1] + triangle[i][i];
        }

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 1; j < i; j++) {
                rst[i][j] = Math.min(rst[i - 1][j], rst[i][j - 1]) + triangle[i][j];
            }
        }

        int min = Integer.MIN_VALUE;
        for (int i = 0; i < w; i++) {
            min = Math.min(min, rst[h - 1][i]);
        }

        return min;


    }
}
