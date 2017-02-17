package Array;
import java.util.*;
/**
 * Created by jli on 4/5/16.
 */
public class TwoSum {
    // 1, 2, 3, 4
    // 3
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> store = new HashMap<Integer, Integer>();
        int[] rst = new int[] {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (store.containsKey(nums[i])) {
                rst[0] = store.get(nums[i]) + 1;
                rst[1] = i + 1;
            } else {
                store.put(target - nums[i], i);
            }
        }

        return rst;
    }

    public int[] twoSumSortArr(int[] numbers, int target) {
        int[] rst = new int[numbers.length];
        Arrays.sort(numbers);
        int start = 0, end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] > target) {
                end --;
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                rst[0] = numbers[start];
                rst[1] = numbers[end];

                break;
            }
        }

        return rst;
    }

}
