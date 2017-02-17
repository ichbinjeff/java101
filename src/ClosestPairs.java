/**
 * Created by jli on 4/15/16.
 */
import java.util.*;
public class ClosestPairs {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] a = new int[count];
        int index = 0;
        while (in.hasNextInt()) {
            a[index ++] = in.nextInt();
        }

        ClosestPairs test = new ClosestPairs();
        List<Integer> rst = test.closestNumber(a);
        StringBuilder rstStr = new StringBuilder();
        for (int i : rst) {
            rstStr.append(i);
            rstStr.append(" ");
        }
        System.out.println(rstStr.toString());
    }
    //1 2 3 4 5 7 9
    public List<Integer> closestNumber(int[] nums) {
        List<Integer> rst = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] < min) {
                min = nums[i] - nums[i - 1];
                rst = new ArrayList<Integer>();
                rst.add(nums[i - 1]);
                rst.add(nums[i]);
            } else if (nums[i] - nums[i - 1] == min) {
                rst.add(nums[i - 1]);
                rst.add(nums[i]);
            }
        }

        return rst;
    }

}
