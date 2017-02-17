/**
 * Created by jli on 10/28/15.
 */
public class LongestIncresingSubset {
    public static int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        // [10,1,11,2,12,3,11]
        int[] f = new int[nums.length];
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            f[i] = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] <= nums[i]) {
                    if (f[i] > f[j] + 1) {
                        f[i] = f[i];
                    } else {
                        f[i] = f[j] + 1;
                    }
                }
            }
            if (f[i] > max) {
                max = f[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] test = new int[] {9,3,6,2,7};
        LongestIncresingSubset.longestIncreasingSubsequence(test);
    }
}
