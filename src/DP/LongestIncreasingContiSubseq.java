package DP;

/**
 * Created by jli on 12/31/15.
 */
public class LongestIncreasingContiSubseq {
    public int LongestIncreasingContiSubseq(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int n = A.length;
        int answer = 1;

        int length = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) {
                length ++;
            } else {
                length = 1;
            }
            answer = Math.max(answer, length);
        }

        length = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                length ++;
            } else {
                length = 1;
            }
            answer = Math.max(answer, length);
        }

        return answer;
    }
}
