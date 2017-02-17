package NineChapter.DP;

/**
 * Created by shli15 on 6/22/16.
 */
public class LongestIncreseasingSeq {
    /*
    For `[5, 4, 1, 2, 3]`, the LIS is [1, 2, 3], return `3`
    For `[4, 2, 4, 5, 3, 7]`, the LIS is `[2, 4, 5, 7]`, return `4`
    */

    // f[n] longest sequence in n
    // f[0] = 1
    // f[1] = 1
    // f[2] = 1
    // f[3] = 2  f[2] + 1 2
    // f[4] = 3  f[3] + 1


    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] f = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            int longest = Integer.MIN_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] <= nums[i]) {
                    longest = Math.max(f[j], longest);
                }
            }

            if (longest >= 0) {
                f[i] = longest + 1;
            }

        }
        // f[n]只能判断当前节点的LIS, 哪个最大还需要再遍历1次
        int max = 0;
        for (int i = 0; i < f.length; i++) {
            max = Math.max(max, f[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] test = new int[] {88,4,24,82,86,1,56,74,71,9,8,18,26,53,77,87,60,27,69,17,76,23,67,14,98,13,10,83,20,43,39,29,92,31,0,30,90,70,37,59};
        LongestIncreseasingSeq LIS = new LongestIncreseasingSeq();
        LIS.longestIncreasingSubsequence(test);
    }

}


