package Array;

/**
 * Created by shli15 on 12/12/16.
 */
public class HouseRobber {
    public int houseRobber2(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(houseRobber(nums, 0, nums.length - 2),
                houseRobber(nums, 1, nums.length - 1));
    }

    private int houseRobber(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int[] f = new int[end-start+1];
        f[0] = nums[start];
        f[1] = Math.max(nums[start], nums[start+1]);
        for (int i = start+2; i <= end; i++) {
            f[i-start] = Math.max(f[i-start-2] + nums[i], f[i-start-1]);
        }
        return f[end-start];
    }

    public static void main(String[] args) {
        int[] tst = new int[] {1,3,2,1,5};
        HouseRobber HR = new HouseRobber();
        int rst = HR.houseRobber2(tst);
        System.out.print(rst);
    }
}
