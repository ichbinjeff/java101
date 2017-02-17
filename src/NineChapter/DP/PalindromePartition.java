package NineChapter.DP;

/**
 * Created by shli15 on 6/26/16.
 */
public class PalindromePartition {
    // abcba
    // f[n] 表示n个字符,最少可以成为几个回文串
    public int miniCut(String s) {
        int[] f = new int[s.length() + 1];
        f[0] = 0;
        // 错误答案
        //for (int i = 1; i < s.length(); i++) {
        for (int i = 1; i <= s.length(); i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (isPalindrome(sub)) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[s.length()] - 1;
    }

    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start ++;
            end --;
        }

        return true;
    }

    public static void main(String[] args) {
        String test = "abccbabb";
        System.out.print("start");
        PalindromePartition PP = new PalindromePartition();
        int cut = PP.miniCut(test);
        System.out.print("cut" + cut);
    }


}
