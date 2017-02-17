/**
 * Created by jli on 10/22/15.
 */
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Permutation {
    // non recursion version
    public static ArrayList<ArrayList<Integer>> run(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> permutations
                = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return permutations;
        }

        int n = nums.size();
        ArrayList<Integer> stack = new ArrayList<Integer>();

        stack.add(-1);
        while (stack.size() != 0) {
            Integer last = stack.get(stack.size() - 1);
            stack.remove(stack.size() - 1);

            // increase the last number
            int next = -1;
            for (int i = last + 1; i < n; i++) {
                if (!stack.contains(i)) {
                    next = i;
                    break;
                }
            }
            if (next == -1) {
                continue;
            }

            // generate the next permutation
            stack.add(next);
            for (int i = 0; i < n; i++) {
                if (!stack.contains(i)) {
                    stack.add(i);
                }
            }

            // copy to permutations set
            ArrayList<Integer> permutation = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                permutation.add(nums.get(stack.get(i)));
            }
            permutations.add(permutation);
        }

        return permutations;
    }

    public static List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return rst;
        }
        List<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(nums[0]);
        while (!stack.isEmpty()) {
            int val = stack.pop();
            list.add(val);
            if (list.size() == nums.length) {
                rst.add(new ArrayList(list));
                list = new ArrayList<Integer>();
            }
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == val) {
                    continue;
                }
                if (!stack.contains(nums[i])) {
                    stack.push(nums[i]);
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testcase = new ArrayList<Integer>();
        testcase.add(1);
        testcase.add(2);
        testcase.add(3);

        ArrayList<ArrayList<Integer>> rst = Permutation.run(testcase);
        int[] test = new int[] {1,2,3};
        Permutation.permute(test);
        System.out.print("ok");
    }

//
//    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
//        // write your code here
//        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
//        ArrayList<Integer> level = new ArrayList<Integer>();
//        if (nums == null || nums.size() == 0) {
//            return rst;
//        }
//
//        permutation(rst, level, nums);
//        return rst;
//    }
//
//    public void permutation(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> level, ArrayList<Integer> nums) {
//        if (level.size() == nums.size()) {
//            rst.add(new ArrayList<Integer>(level));
//            return;
//        }
//
//        for (int i = 0; i < nums.size(); i++) {
//            if (level.contains(nums.get(i))) {
//                continue;
//            }
//            level.add(nums.get(i));
//            permutation(rst, level, nums);
//            level.remove(level.size() - 1);
//        }
//    }
}
