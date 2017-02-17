package NineChapter.DP;

/**
 * Created by shli15 on 7/5/16.
 *  For s1 = "aabcc", s2 = "dbbca"
 When s3 = "aadbbcbcac", return true.
 When s3 = "aadbbbaccc", return false.
 */

//abcde
//abceg
//abcdegbcdg

public class InterleavingString {
    public boolean interleavingString(String A, String B, String C) {
        if (A.length() + B.length() != C.length()) {
            return false;
        }

        boolean[][] f = new boolean[A.length() + 1][B.length() + 1];
        f[0][0] = true;
        for (int i = 1; i <= A.length(); i++) {
            f[i][0] = A.charAt(i - 1) == C.charAt(i - 1);
        }

        for (int i = 1; i <= B.length(); i++) {
            f[0][i] = B.charAt(i - 1) == C.charAt(i - 1);
        }

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (f[i - 1][j] && A.charAt(i - 1) == C.charAt(i + j - 1)
                        || f[i][j - 1] && B.charAt(j - 1) == C.charAt(i + j - 1)) {
                    f[i][j] = true;
                }
            }
        }

        return f[A.length()][B.length()];
    }

}

