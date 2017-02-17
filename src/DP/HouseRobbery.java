package DP;

/**
 * Created by jli on 2/15/16.
 */
public class HouseRobbery {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length < 2) {
            return nums[0];
        }

        int[] f = new int[nums.length];
        f[0] = nums[0];
        f[1] = Math.max(nums[1], nums[0]);

        for (int i = 2; i < nums.length; i++) {
            f[i] = Math.max(f[i - 1], f[i - 2] + f[i]);
        }

        return f[nums.length - 1];
    }
}
