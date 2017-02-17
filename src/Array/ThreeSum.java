package Array;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by jli on 4/5/16.
 */
public class ThreeSum {
    // 1 2 3 4 5   6
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();

        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            int currTarget = 0 - numbers.length;
            int start = i + 1;
            int end = numbers.length - 1;

            while (start < end) {
                int sum = numbers[start] + numbers[end];
                if (sum == currTarget) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(start);
                    list.add(end);
                    list.add(i);
                } else if (sum < currTarget) {
                    start ++;
                } else {
                    end --;
                }
            }
        }
        return rst;
    }
}
