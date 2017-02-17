package DP;

/**
 * Created by jli on 4/6/16.
 */
public class LongestIncreasingSub {
    public int LongestIncreasingSub(int[] nums) {
        // [1,1,1,1,1,1,1]
        // [9,3,6,2,7]
        int[] rst = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            rst[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    rst[i] = Math.max(rst[j] + 1, rst[i]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < rst.length; i++) {
            max = Math.max(rst[i], max);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] tst = new int[] {10,1,11,2,12,3,11};
        LongestIncreasingSub LISB = new LongestIncreasingSub();
        int rst = LISB.LongestIncreasingSub(tst);
        System.out.print("end");
    }

}
