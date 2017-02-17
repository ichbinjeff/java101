package Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jli on 3/7/16.
 */
public class MaxSubArraySum {
    public int subArrSum(int[] nums) {
        int minSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(sum - minSum, maxSum);
            minSum = Math.min(minSum, sum);
        }

        return maxSum;
    }

    // 1,3,-1,2,-1,2
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int sum = nums.get(i);
            for (int j = i + 1; j < nums.size(); j++) {
                sum += nums.get(j);
                max = Math.max(sum, max);
            }
        }

        return max;
    }

    public int subArrSumDP(int[] nums) {
        int[] local = new int[nums.length];
        int max = Integer.MIN_VALUE;
        local[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            local[i] = Math.max(local[i - 1], local[i - 1] + nums[i]);
            max = Math.max(max, local[i]);
        }

        return max;


    }

    public int minArrSum(int[] nums) {
        int maxSum = 0;
        int minSum = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            minSum = Math.min(sum - maxSum, minSum);
            maxSum = Math.max(sum, maxSum);
        }

        return minSum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> rst = new ArrayList<Integer>(Arrays.asList(1,3,-1,2,-1,2));
        MaxSubArraySum MSA = new MaxSubArraySum();
        MSA.maxTwoSubArrays(rst);
        String c = "";
        Long s = Long.parseLong(c);
        System.out.print(s);
    }

    // 1,3,-1,2,-1,2
    // 1,4,4,6,5,7
    public int subArraySum(int[] nums) {
        int[] f = new int[nums.length];
        f[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(f[i - 1] + nums[i], nums[i]);
        }

        int rst = Integer.MIN_VALUE;
        for (int item : f) {
            rst = Math.max(rst, item);
        }

        return rst;
    }
}
