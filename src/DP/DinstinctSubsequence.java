package DP;

/**
 * Created by jli on 1/25/16.
 */
public class DinstinctSubsequence {
    public int numDistinct(String S, String T) {
        // write your code here
        if (S == null || T == null) {
            return 0;
        }

        int[][] rst = new int[S.length() + 1][T.length() + 1];

        for (int i = 0; i <= S.length(); i++) {
            rst[i][0] = 1;
        }

        for (int i = 1; i <= T.length(); i++) {
            rst[0][i] = 0;
        }

        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    rst[i][j] = rst[i - 1][j] + rst[i - 1][j - 1];
                } else {
                    rst[i][j] = rst[i - 1][j];
                }
            }
        }

        return rst[S.length()][T.length()];
    }


}
