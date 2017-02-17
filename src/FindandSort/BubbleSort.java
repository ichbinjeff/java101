package FindandSort;

/**
 * Created by jli on 2/15/16.
 */
public class BubbleSort {
    public int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
               if (nums[j] < nums[i]) {
                   int temp = nums[i];
                   nums[i] = nums[j];
                   nums[j] = temp;
               }
            }

        }

        return nums;
    }

    public static void main(String[] args) {
        int[] a = new int[] {5, 4, 3, 2, 1};
        BubbleSort bb = new BubbleSort();
        bb.sort(a);
        System.out.print("done");
    }
}
