package DP;

/**
 * Created by jli on 1/25/16.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        // write your code here
        int[][] f = new int[word1.length() + 1][word2.length()];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                f[i][j] = 0;
            }
        }
        // abc
        // bbb
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(j) == word2.charAt(j)) {
                    f[i][j] = Math.min(f[i - 1][j] + 1, f[i - 1][j - 1]);
                } else {
                    f[i][j] = Math.min(f[i - 1][j], f[i - 1][j]) + 1;
                }
            }
        }

        return f[word1.length()][word2.length()];
    }
}
