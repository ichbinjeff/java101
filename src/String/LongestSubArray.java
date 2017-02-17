package String;

/**
 * Created by shli15 on 9/20/16.
 */
public class LongestSubArray {
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int max = 0;
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                int count = 0;
                while (i + count < A.length() && j + count < B.length() && A.charAt(i + count) == B.charAt(j + count)){
                    count ++;
                }
                max = Math.max(max, count);
            }

        }
        return max;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        for (int start = 0; start < gas.length; start++) {
            int[] f = new int[gas.length + 1];
            for (int i = 0; i <= gas.length; i++) {
                f[i] = Integer.MIN_VALUE;
            }

            f[0] = 0;
            for (int i = 1; i <= gas.length; i++) {
                f[i] = f[i - 1] + gas[(i - 1 + start) % gas.length] - cost[(i - 1 + start) % gas.length];
                if (f[i] < 0) {
                    break;
                }
            }

            if (f[gas.length] >= 0) {
                return start;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        LongestSubArray LSA = new LongestSubArray();
        int rst = LSA.longestCommonSubstring("www.lintcode.com code", "www.ninechapter.com code");

        int[] gas = new int[] {1,1,3,1};
        int[] cost = new int[] {2,2,1,1};
        int index = LSA.canCompleteCircuit(gas, cost);
        System.out.print(index);
    }
}
