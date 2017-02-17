package NineChapter.DP;

/**
 * Created by shli15 on 7/5/16.
 */
// Given A = "ABCD", B = "CBCE", return 2.
public class LongestCommonSubString {
    public int LongestCommonSubString(String A, String B) {
        /* 错误答案1
        int[][] f = new int[A.length() + 1][B.length() + 1];
        for (int i = 0; i <= A.length(); i++) {
            f[i][0] = 0;
        }

        for (int i = 0; i <= B.length(); i++) {
            f[0][i] = 0;
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
        */

        /* 错误答案2
        //ABCD
        //ABCD
        int max = 0;
        for (int i = 0; i < A.length(); i++) {
            int count = 0;
            int indexI = i, indexJ = 0;
            while (indexI < A.length()
                    && indexJ < B.length()
                    && A.charAt(indexI) == B.charAt(indexJ)) {
                count ++;
                indexI ++;
                indexJ ++;
            }
            max = Math.max(max, count);
        }

        return max; */
        int max = 0;
        for (int i = 0; i < A.length(); i++) {
            // len应该放到j循环里面
            // int len = 0;
            for (int j = 0; j < B.length(); j++) {
                int len = 0;
                while (i + len < A.length()
                        && j + len < B.length()
                        && A.charAt(i + len) == B.charAt(j + len)) {
                    len ++;
                }
                max = Math.max(max, len);
            }
        }

        return max;

    }

    public static void main(String[] args) {
        String A = "www.lintcode.com code";
        String B = "www.ninechapter.com code";
        LongestCommonSubString LCS = new LongestCommonSubString();
        LCS.LongestCommonSubString(A, B);
        System.out.print("done");
    }

}
