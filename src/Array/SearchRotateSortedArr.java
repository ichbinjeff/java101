package Array;

/**
 * Created by shli15 on 12/2/16.
 */
public class SearchRotateSortedArr {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int min = 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] < nums[end]) {
            min = start;
        } else {
            min = end;
        }
        if (target == nums[0]) return 0;
        else if (target > nums[0] && start != 0) {
            start = 0;
            if (min > 0)
                end = min - 1;
        } else {
            start = min;
            end = nums.length - 1;
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchRotateSortedArr SRSA = new SearchRotateSortedArr();
        int[] arr = new int[]{1};
        int rst = SRSA.search(arr, 0);
        System.out.print(rst);
    }
}
