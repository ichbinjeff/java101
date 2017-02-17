package NineChapter.DP;

/**
 * Created by shli15 on 6/26/16.
 */
public class IsPalindrome {
    // abccba
    public boolean[][] isPalindrome(String s) {
        boolean[][] isPal = new boolean[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            isPal[i][i] = true;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; i < s.length(); i++) {
                isPal[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            }
        }

        for (int len = 2; len < s.length(); len++) {
            for (int start = 0; start < s.length(); start++) {
                isPal[start][start + len] = isPal[start + 1][start + len - 1]
                        && (s.charAt(start + 1) == s.charAt(start + len - 1));
            }
        }

        return isPal;
    }

    // abccba
    public int minCut(String s) {
        // f[n] 表示n个字符,最少被切成几个回文串
        int[] f = new int[s.length()];
        f[0] = 0;
        boolean[][] palindrome = isPalindrome(s);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < s.length(); i++) {
            for (int j = i - 1; j > 0; j--) {
                if (palindrome[0][j]) {
                    f[i] = Math.min(f[j], min) + 1;
                }
            }
        }

        return f[s.length()] - 1;
    }

    public static void main(String[] args) {
    }

}
