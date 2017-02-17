package Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

/**
 * Created by shli15 on 9/21/16.
 */
public class ProductOfArr {
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> rst = new ArrayList<Long>();
        for (int i = 0; i < A.size(); i++) {
            Long product = 1l;
            for (int j = 0; j < A.size(); j++) {
                if (j == i) {
                    continue;
                }
                product *= A.get(j);
            }

            rst.add(product);
        }

        return rst;
    }

    // 1, 2, 3
    // 6
    public int threeSumClosest(int[] numbers ,int target) {
        Arrays.sort(numbers);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            int targetCurr = target - numbers[i];

            int start = 0;
            int end = numbers.length - 1;

            while (start < end) {
                if (start == i) {
                    start ++;
                    continue;
                }

                if (end == i) {
                    end --;
                    continue;
                }

                int sum = numbers[start] + numbers[end];
                int diff = Math.abs(targetCurr - sum) + targetCurr;
                min = Math.min(diff, min);

                if (targetCurr > sum) {
                    start ++;
                } else {
                    end --;
                }
            }
        }
        return min;
    }
}
