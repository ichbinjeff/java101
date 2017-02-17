package Array;
import java.util.*;

/**
 * Created by jli on 4/6/16.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] numbers ,int target) {
        Arrays.sort(numbers);
        int min = Integer.MAX_VALUE;
        int rst = 0;
        for (int i = 0; i < numbers.length; i++) {
            int targetCurr = target - numbers[i];

            int start = i + 1;
            int end = numbers.length - 1;

            while (start < end) {
                int sum = numbers[start] + numbers[end];
                int diff = Math.abs(targetCurr - sum);
                if (diff < min) {
                    rst = sum + numbers[i];
                    min = diff;
                }

                if (targetCurr > sum) {
                    start ++;
                } else {
                    end --;
                }

            }
        }

        return rst;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,7,11,15};
        ThreeSumClosest tsc = new ThreeSumClosest();
        int rst = tsc.threeSumClosest(arr, 3);
        System.out.print("done");
    }

}
