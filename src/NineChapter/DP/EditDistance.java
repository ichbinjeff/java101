package NineChapter.DP;

/**
 * Created by shli15 on 6/27/16.
 */
public class EditDistance {
    // abc
    // abcd
    // f[i - 1][j], f[i][j - 1]
    // 相同
    // f[i - 1][j - 1]
    public int EditDistance(String s1, String s2) {
        // 从旧数组到新数组,有几种方法
        int[][] f = new int[s1.length() + 1][s2.length() + 1];
        f[0][0] = 0;
        // 这里不能从0开始,因为f[0][0] = 0
//        for (int i = 0; i <= s1.length(); i++) {
//            f[i][0] = 1;
//        }

        for (int i = 0; i <= s1.length(); i++) {
            f[i][0] = f[i - 1][0] + 1;
        }

        for (int i = 0; i <= s2.length(); i++) {
            // 这里需要初始化为前一个加1, 因为前n - 1个有几种方法,
            // 多删除一个就是n 最少有几种方法
            // f[0][i] = 1;
            f[0][i] = f[0][i - 1] + 1;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                //if (s1.charAt(i) == s2.charAt(j)) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    f[i][j] = Math.min(Math.min(f[i - 1][j], f[i][j - 1]) + 1, f[i - 1][j - 1]);
                } else {
                    f[i][j] = Math.min(Math.min(f[i - 1][j], f[i][j - 1]), f[i - 1][j - 1]) + 1;
                }
            }
        }

        return f[s1.length()][s2.length()];
    }
}
