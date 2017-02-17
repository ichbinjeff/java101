package FindandSort;

/**
 * Created by jli on 3/6/16.
 */
public class Median {
    public int median(int[] nums) {
        // write your code here
        int k = (nums.length - 1) / 2;
        quickSelect(nums, 0, nums.length - 1, k);
        return nums[k];
    }

    public void quickSelect(int[] nums, int start, int end, int k) {
        if (start < end) {
            int mid = patition(nums, start, end);
            if (mid > k) {
                quickSelect(nums, start, mid - 1, k);
            } else {
                quickSelect(nums, mid + 1, end, k);
            }
        }
    }

    public int patition(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        while (start < end) {
            while (start < end && nums[start] < nums[mid]) {
                start++;
            }

            while (start < end && nums[end] > nums[mid]) {
                end--;
            }

            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }

        return mid;
    }

    public static void main(String[] args) {
        int[] input = new int[] {4,5,1,2,3};
        Median m = new Median();
        int mm = m.median(input);
        System.out.print("haha");

    }
}
