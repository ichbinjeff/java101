package FindandSort;

/**
 * Created by jli on 2/1/16.
 */
public class QuickSort {
    public int partition(int [] nums, int start, int end) {
//        int pivot = nums[start];
//        while (start < end) {
//            while (start < end && nums[end] >= pivot) {
//                end --;
//            }
//
//            if (start < end) {
//                nums[start++] = nums[end];
//            }
//
//            while (start < end && nums[start] <= pivot) {
//                start ++;
//            }
//
//            if (start < end) {
//                nums[end--] = nums[start];
//            }
//        }
//
//        nums[start] = pivot;
//        return start;
        int mid = (start + end) / 2;
        while (start < end) {
            while (start < end && nums[start] < nums[mid]) {
                start ++;
            }

            while (start < end && nums[end] > nums[mid]) {
                end --;
            }

            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }
        return mid;
    }

    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = partition(nums, start, end);
            quickSort(nums, start, mid - 1);
            quickSort(nums, mid + 1, end);
        }
    }


    public static void main(String[] args) {
        int[] input = new int[] {1,5,4,3,2};
        QuickSort qs = new QuickSort();
        qs.quickSort(input);
        System.out.print("haha");


        //1 2 3 4 5
        int value = input[0];
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < input.length; i++) {
            value = Math.max(value, input[i - 1]);
            min = Math.min(min, input[i] - value);
        }

        System.out.print(min);
    }
}


