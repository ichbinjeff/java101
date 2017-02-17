package NineChapter.DP;

/**
 * Created by shli15 on 6/22/16.
 */
public class JumpGame {
    // A = [2,3,1,1,4], return true.
    // f[n] can jump to this index
    // f[0] = true
    // f[1] = 0 + 2 > 1 true
    // f[2] = 0 + 2 >= 2, 1 + 3 >= 1
    // f[3] =
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }

        boolean[] f= new boolean[A.length];
        f[0] = true;
        for (int i = 1; i < A.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (f[j - 1] && j - 1 + A[j - 1] >= i) {
                    f[i] = true;
                }
            }
            /* 错误答案, 这行会overwrite, 不要这行, 默认已经是false了
            f[i] = false; */
        }

        return f[A.length - 1];
    }

    /* Follow up
    Given array A = [2,3,1,1,4]

    The minimum number of jumps to reach the last index is 2.
    (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
    */
    // state: f[n] steps to n
    // f[0] = 0;
    // f[1] = 1;
    // f[2] = 1;   0 - 2, 0-1-2
    // f[3] = f[2] + 1 2  f[1] + 3  2
    // f[4] = f[1] + 3
    public int canJumpSteps(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] f = new int[A.length];
        f[0] = 0;
        if (A[0] < 1) {
            return 0;
        }

        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] + j >= i) {
                    f[i] = f[j] + 1;
                    // break 很关键
                    break;
                }
            }
        }

        return f[A.length - 1];
    }

}
