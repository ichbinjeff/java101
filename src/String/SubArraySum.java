package String;
import java.util.ArrayList;
/**
 * Created by shli15 on 9/20/16.
 */
public class SubArraySum {
    public ArrayList<Integer> SubArraySum(int[] nums) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == 0) {
                    rst.add(i);
                    rst.add(j);
                    return rst;
                }
            }
        }
        return rst;
    }

    // A = [1,1,2]
    public int removeDuplicates(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] == nums[start + 1]) {
                start++;
            }
        }

        return end + 1;

    }




    public static void main(String[] args) {

    }
}
