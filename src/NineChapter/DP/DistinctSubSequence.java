package NineChapter.DP;

/**
 * Created by shli15 on 7/3/16.
 */
// 题意为从S有集中删除方法到T
public class DistinctSubSequence {
    public int numDistinct(String S, String T) {
        // f 表示从前n个S字符去若干字符,组成前n个j字符,有几种方案
        int[][] f = new int[S.length() +  1][T.length() + 1];

        for (int i = 0; i <= S.length(); i++) {
            f[i][0] = 1;
        }

        for (int i = 0; i <= T.length(); i++) {
            f[0][i] = 0;
        }

        f[0][0] = 1;

        for (int i = 1; i <= S.length(); i++) {
            for (int j = 1; j <= T.length(); j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
        }

        return f[S.length()][T.length()];
    }
}
