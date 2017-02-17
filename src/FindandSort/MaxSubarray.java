package FindandSort;

/**
 * Created by jli on 1/5/16.
 */
// [-1, 2, 3, 4, -2, 6, -10]
public class MaxSubarray {
    public int MaxSubarray(int[] nums) {
        // GREEDY
//        int min = 0;
//        int sum = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            min = Math.min(sum, min);
//            sum = Math.min(sum, 0);
//        }
//
//        return min;

//        int[] global = new int[nums.length];
//        int[] local = new int[nums.length];
//        global[0] = nums[0];
//        local[0] = nums[0];
//
//        for (int i = 1; i < nums.length; i++) {
//            local[i] = Math.min(nums[i], local[i - 1] + nums[i]);
//            global[i] = Math.min(global[i - 1], local[i]);
//        }
//
//        return global[nums.length - 1];
        int[] curr = new int[nums.length];
        int[] global = new int[nums.length];

        curr[0] = nums[0];
        global[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr[i] = Math.max(nums[i], curr[i - 1] + nums[i]);
            global[i] = Math.max(global[i - 1], curr[i]);
        }

        return global[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] input = new int[]{-1, 2, 3, 4, -2, 6, -10};
        MaxSubarray ms = new MaxSubarray();
        int out = ms.MaxSubarray(input);
        System.out.print("here");
    }
}
