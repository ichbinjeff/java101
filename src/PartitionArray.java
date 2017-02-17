/**
 * Created by jli on 10/22/15.
 */
public class PartitionArray {
    // [3,2,2,1]
    public static int run(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] < k) {
                start++;
            } else {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                end --;
            }
        }
        if (nums[end] < k) {
            return end + 1;
        }
        return end;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 2, 1};
        int rst = PartitionArray.run(nums, 2);
        System.out.print(rst);
    }
}
