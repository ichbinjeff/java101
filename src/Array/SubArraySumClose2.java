package Array;

/**
 * Created by shli15 on 1/4/17.
 */
public class SubArraySumClose2 {
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        Result[] store = new Result[nums.length];
        store[0] = new Result(0, 0, nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(nums[i]) < Math.abs(nums[i] + store[i-1].sum)) {
                store[i] = new Result(i, i, nums[i]);
            } else {
                store[i] = new Result(store[i-1].start, i, store[i-1].sum + nums[i]);
            }
        }

        Result min = store[0];
        for (int i = 0; i < store.length; i++) {
            if (Math.abs(store[i].sum) < Math.abs(min.sum)) {
                min = store[i];
            }
        }
        return new int[] {min.start, min.end};
    }

    private class Result {
        int start;
        int end;
        int sum;

        public Result(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        int[] tst = new int[] {101,33,44,55,67,78,-101,33,-44,55,-67,78,-100,200,-1000,22,100,200,1000,22};
        SubArraySumClose2 SAS = new SubArraySumClose2();
        SAS.subarraySumClosest(tst);
    }
}
