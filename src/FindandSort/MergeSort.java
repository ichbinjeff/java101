package FindandSort;

/**
 * Created by jli on 2/1/16.
 */
public class MergeSort {
    public void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    public void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return ;
        }

        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    public void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            temp[i - start] = nums[i];
        }

        int i = start, j = mid + 1;
        int index = 0;
        while (i <= mid && j <= end) {
            if (temp[i] < temp[j]) {
                nums[index ++] = temp[i ++];
            } else {
                nums[index ++] = temp[j ++];
            }
        }

        while (i <= mid) {
            nums[index ++] = temp[i ++];
        }

        while (j <= end) {
            nums[index ++] = temp[j ++];
        }
    }

    public static void main(String[] args) {
        int[] input = new int[] {5, 2, 4, 3, 1};
        MergeSort MS = new MergeSort();
        MS.mergeSort(input);
        System.out.print("haha");
    }
}
