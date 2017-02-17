/**
 * Created by jli on 10/30/15.
 */
public class Jumpgame {
    public static boolean canJump(int[] A) {
        // wirte your code here
        if (A == null || A.length == 0) {
            return false;
        }

        int n = A.length;
        boolean[] can = new boolean[n];

        can[0] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && A[j] + j >= i) {
                    can[i] = true;
                }
            }
        }

        return can[A.length - 1];
    }

    public static int jumpStep(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] steps = new int[n];
        steps[0] = 0;

        for (int i = 1; i < n; i++) {
            steps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && A[j] + j >= i) {
                    steps[i] = steps[j] + 1;
                }
            }
        }

        return steps[A.length - 1];

    }

    public static void main(String[] args) {
        int[] test = new int[] {2,3,1,1,4};
        Jumpgame.jumpStep(test);
    }
}
