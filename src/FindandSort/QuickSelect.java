package FindandSort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jli on 3/6/16.
 */
public class QuickSelect {
    public int partition(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        while (start < end) {
            while (start < end && nums[start] < nums[mid]) {
                start ++;
            }

            while (start < end && nums[mid] < nums[end]) {
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

    public int quickSelect(int[] nums, int k) {
        quickSelect(nums, 0, nums.length - 1, k);
        return nums[k];
    }

    public void quickSelect(int[] nums, int start, int end, int k) {
        if (start < end) {
            int mid = partition(nums, start, end);
            if (k < mid) {
                quickSelect(nums, start, mid - 1, k);
            } else {
                quickSelect(nums, mid + 1, end, k);
            }
        }
    }

    public static void main(String[] args) {
        int[] input = new int[] {5, 2, 4, 3, 1};
        QuickSelect qs = new QuickSelect();
        qs.quickSelect(input, 1);
        List<Integer> sample = new ArrayList<Integer>();
        sample.add(null);
        sample.add(1);
        sample.add(2);
        System.out.print("haha");

        ArrayList rst = new ArrayList();
        rst = null;

        if (rst.size() > 100) {
            System.out.print("learn something");
        }

    }

}
