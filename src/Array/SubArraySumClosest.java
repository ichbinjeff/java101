package Array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Arrays;

/**
 * Created by jli on 4/1/16.
 */
public class SubArraySumClosest {
    // [-3, 1, 1, -3, 5]
    //    -1 0
    //    0 -3
    //    1 -2
    //    2 -1
    //    3 -4
    //    4 1

    private class Pair {
        int index;
        int sum;

        public Pair(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }

    }
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        // 0 1 2 3 4
        Pair[] sums = new Pair[nums.length + 1];
        sums[0] = new Pair(0, 0);
        int prev = 0;
        for(int i = 1; i <= nums.length; i++) {
            sums[i] = new Pair(i, prev + nums[i - 1]);
            prev = sums[i].sum;
        }

        Arrays.sort(sums, SumComparator);
        int minDiff = Integer.MAX_VALUE;
        int[] rst = new int[2];

        for (int i = 1; i <= nums.length; i++) {
            if (sums[i].sum - sums[i - 1].sum < minDiff) {
                minDiff = sums[i].sum - sums[i - 1].sum;
                int[] temp = new int[2];
                temp[0] = sums[i - 1].index - 1;
                temp[1] = sums[i].index - 1;

                Arrays.sort(temp);
                rst[0] = temp[0] + 1;
                rst[1] = temp[1];
            }
        }

        return rst;

    }

    public Comparator<Pair> SumComparator = new Comparator<Pair>() {
        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.sum - o2.sum;
        }
    };

    public static void main(String[] args) {
        int[] test = new int[] {-3,2,2,4};
        SubArraySumClosest sac = new SubArraySumClosest();
        int[] ans = sac.subarraySumClosest(test);
        System.out.print("done");
    }
}
