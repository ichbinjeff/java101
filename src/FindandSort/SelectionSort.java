package FindandSort;

/**
 * Created by jli on 2/15/16.
 */
public class SelectionSort {
    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int minIndex = 0;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < min) {
                    minIndex = j;
                    min = nums[j];
                }
            }
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] a = new int[] {5, 4, 3, 2, 1};
        SelectionSort ss = new SelectionSort();
        ss.sort(a);
        System.out.print("done");
    }
}
