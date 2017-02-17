package NineChapter.DP;

/**
 * Created by shli15 on 6/22/16.
 */
public class ClimbStairs {
    // f[n] climb n stairs ways
    // f[0] = 0
    // f[1] = 1
    // f[2] = 2 (1,1, 2)
    // f[3] = 3 (1,1,1, 1,2  2,1)
    // f[4] = 5  (1,1,1,1  1,2,1 1,1,2 1,1,2 2,2)

    public int climbStairs(int n) {
        int[] f = new int[n + 1];
        if (n == 0) {
            return 0;
        }

        if (n >= 1) {
            f[1] = 1;
        }

        if (n >= 2) {
            f[2] = 2;
        }

        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    public int climbstaris2(int n) {
        int[] f = new int[n + 1];
        f[0] = 1;
        if (n > 0) {
            f[1] = 1;
        }

        if (n > 1) {
            f[2] = 2;
        }

        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2] + f[i - 3];
        }

        return f[n];
    }


    public static void main(String[] args) {
        ClimbStairs CS = new ClimbStairs();
        int rst = CS.climbstaris2(5);
        System.out.print(rst);
    }
}
