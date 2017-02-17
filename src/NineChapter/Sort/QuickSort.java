package NineChapter.Sort;

/**
 * Created by shli15 on 7/1/16.
 */
public class QuickSort {
    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int start, int end) {
        // 这个if check极为重要,否则就死循环了
        if (start < end) {
            int mid = partition(nums, start, end);
            quickSort(nums, 0, mid - 1);
            quickSort(nums, mid + 1, end);
        }
    }
    // 1
    // 15432

    // start = 0
    // end = 4
    // end = 0
    public int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        while (start < end) {
            while (start < end && pivot <= nums[end]) {
                end --;
            }

            if (start < end) {
                nums[start ++] = nums[end];
            }

            while (start < end && pivot >= nums[start]) {
                start ++;
            }

            if (start < end) {
                nums[end--] = nums[start];
            }
        }

        nums[start] = pivot;
        return start;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,5,4,3,2};
        QuickSort qs = new QuickSort();
        qs.quickSort(input);
        System.out.print("haha");
    }


}
