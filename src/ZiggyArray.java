/**
 * Created by jli on 4/12/16.
 */
import java.util.*;

public class ZiggyArray {
    public int[] ZiggyArray(int[] numbers) {
        int[] rst = new int[numbers.length];
        if (numbers == null || numbers.length == 0) {
            return rst;
        }
        // 1 1 2 2 3 4
        Arrays.sort(numbers);
        int start = 0, end = numbers.length - 1, index = 0;
        while (start < end) {
            if (index % 2 == 0) {
                rst[index ++] = numbers[start ++];
            } else {
                rst[index ++] = numbers[end --];
            }
        }
        rst[index] = numbers[start];
        return rst;
    }

    // sort method
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        Arrays.sort(nums);
        //1 2 3 4 5
        //1 3 2 5 4
        for (int i = 2; i < nums.length; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = temp;
        }
    }

    // sort method exchange
    public void wiggleSortEx(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // a < b > c < d > e
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 != 0 && nums[i] < nums[i - 1])
                    || (i % 2 == 0 && nums[i] > nums[i - 1])) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
    }

    // 1 2 3 4 4
    // 3 4 2 4 1
    public void wiggleSort2(int[] nums) {
        Arrays.sort(nums);
        int start = nums.length / 2;
        int end = nums.length;
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                tmp[i] = nums[start --];
            } else {
                tmp[i] = nums[--end];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmp[i];
        }
    }


    public static void main(String[] args) {
        int[] tst = new int[] {1,1,2,1,2,2,1};
        ZiggyArray ZA = new ZiggyArray();
        int[] rst = ZA.ZiggyArray(tst);
        ZA.wiggleSort2(tst);

        System.out.print("done");
    }
}
