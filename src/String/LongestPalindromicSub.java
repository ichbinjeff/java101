package String;

/**
 * Created by shli15 on 12/3/16.
 */
public class LongestPalindromicSub {
    public String longestPalindromeDP(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        int max = 0;
        String rst = "";
        boolean[][] f = new boolean[s.length() + 1][s.length() + 1];
        f[0][0] = true;

        for (int i = 0; i < s.length(); i++) {
            f[i][i] = true;
            if (i + 1 < s.length()) {
                f[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
                if (f[i][i + 1]) {
                    max = 1;
                    rst = s.substring(i, i + 2);
                }
            }
        }

        for (int k = 2; k < s.length(); k++) {
            for (int i = 0; i < s.length() - k; i++) {
                int j = i + k;
                f[i][j] = s.charAt(i) == s.charAt(j) && f[i + 1][j - 1];
                if (f[i][j] && k > max) {
                    max = k;
                    rst = s.substring(i, j + 1);
                }
            }
        }

        if (max == 0) {
            return s.substring(0, 1);
        }

        return rst;
//        String rst = "";
//        int longest = 0;
//        boolean[][] f = new boolean[s.length()][s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            f[i][i] = true;
//            if (i < s.length() - 1)
//                f[i][i+1] = s.charAt(i) == s.charAt(i + 1);
//        }
//
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 2; j < s.length() - i; j++) {
//                int k = i + j;
//                f[i][k] = f[i+1][k-1] && s.charAt(i) == s.charAt(k);
//            }
//        }
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 0; j < s.length(); j++) {
//                if (f[i][j] && j - i > longest) {
//                    longest = j - i;
//                    rst = s.substring(i, j + 1);
//                }
//            }
//        }
//        if (longest == 0) return s.substring(0, 1);
//        return rst;
    }

    public String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j <= s.length() - i; j++) {
                String substr = s.substring(i, i + j);
                if (isPalindrome(substr) && j > longest.length()) {
                    longest = substr;
                }
            }
        }
        return longest;
    }

    private boolean isPalindrome(String substr) {
        int start = 0, end = substr.length() - 1;
        while (start < end) {
            if (substr.charAt(start) != substr.charAt(end)) {
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }



    public static void main(String[] args) {
        LongestPalindromicSub LP = new LongestPalindromicSub();
        LP.longestPalindromeDP("abcba");
    }
}
