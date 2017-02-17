package String;

/**
 * Created by shli15 on 12/3/16.
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int prod = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                prod *= nums[j];
                max = Math.max(prod, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxProduct MP = new MaxProduct();
        int[] tst = new int[] {-2,0,-1};
        int max = MP.maxProduct(tst);
        System.out.print(max);
    }
}
