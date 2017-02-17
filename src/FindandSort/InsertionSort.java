package FindandSort;

/**
 * Created by jli on 2/15/16.
 */
public class InsertionSort {
    public int[] sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > temp) {
                nums[j + 1] = nums[j];
                j --;
            }
            nums[j + 1] = temp;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] a = new int[] {5, 4, 3, 2, 1};
        InsertionSort is = new InsertionSort();
        is.sort(a);
        System.out.print("done");
    }
}
