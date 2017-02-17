package Array;

import java.util.ArrayList;
import java.util.*;

/**
 * Created by jli on 4/6/16.
 */
public class LongestIncreasingContinousSubSequence {
    public int longestIncreasingContinuousSubsequence(int[] A) {
        int len = 1;
        int ans = 1;

        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                len ++;
            } else {
                len = 1;
            }

            ans = Math.max(len, ans);
        }

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                len ++;
            } else {
                len = 1;
            }

            ans = Math.max(len, ans);
        }

        return len;
    }


    public List<Integer> LIS(int[] A) {
        int start = 0, len = 1, max = 1, end = 0, last = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                len ++;
            } else {
                len = 1;
                start = i;
            }

            if (len > max) {
                last = start;
                end = i;
                max = len;
            }
        }

        List<Integer> rst = new ArrayList<Integer>();
        rst.add(last);
        rst.add(end);

        return rst;
    }

    public static void main(String[] args) {
        int[] tst = new int[] {8,2,3,4,5,2};
        LongestIncreasingContinousSubSequence LIS = new LongestIncreasingContinousSubSequence();
        List<Integer> rst = LIS.LIS(tst);
        System.out.print(rst);
    }


}
