package DP;

/**
 * Created by jli on 1/25/16.
 */
public class LongestCommonSubSequence {
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int[][] rst = new int[A.length() + 1][B.length() + 1];
        rst[0][0] = 0;
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    int maxPrev = Math.max(rst[i - 1][j], rst[i][j - 1]);
                    rst[i][j] = Math.max(rst[i - 1][j - 1] + 1, maxPrev);
                } else {
                    rst[i][j] = Math.max(rst[i - 1][j], rst[i][j - 1]);
                }
            }
        }

        return rst[A.length()][B.length()];
    }
}
