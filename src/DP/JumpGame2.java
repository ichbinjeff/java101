package DP;

/**
 * Created by jli on 4/6/16.
 */
public class JumpGame2 {
    public int jump2(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int[] steps = new int[A.length];
        for (int i = 1; i < A.length; i++) {
            steps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (A[j] + j >= i) {
                    steps[i] = steps[j] + 1;
                    break;
                }
            }
        }

        return steps[A.length - 1];
    }

    // [5,8,3,0,6,7,9,6,3,4,5,2,0,6,2,6,7,10,8,0]
    public boolean canJump(int[] A) {
        /* WRONG SOLUTION
        if (A == null || A.length == 0) {
            return false;
        }

        boolean[] canJump = new boolean[];
        canJump[0] = true;
        //1 2 3
        for (int i = 1; i < A.length; i++) {
           canJump[i] = canJump[i - 1] && A[i - 1] + i - 1 >= i;
        }

        return canJump[A.length - 1];
        **/

        if(A == null || A.length == 0) {
            return false;
        }

        boolean[] canJump = new boolean[A.length];
        canJump[0] = true;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (canJump[j] && A[j] + j >= i) {
                    canJump[i] = true;
                }
            }
        }

        return canJump[A.length - 1];
    }
}
