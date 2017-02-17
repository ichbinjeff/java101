package NineChapter.DP;

/**
 * Created by shli15 on 7/5/16.
 */
public class LongestCommonSubsequence {
    public int LongestCommonSubsequence(String A, String B) {
        int [][] f = new int[A.length()][B.length()];
        for (int i = 0; i <= A.length(); i++) {
            f[i][0] = 0;
        }

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = Math.max(f[i - 1][j - 1] + 1, Math.max(f[i - 1][j], f[i][j - 1]));
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }

        return f[A.length()][B.length()];
    }
}
