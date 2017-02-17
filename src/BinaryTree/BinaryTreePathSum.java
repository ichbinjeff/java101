package BinaryTree;
import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

import java.util.List;
import java.util.ArrayList;
/**
 * Created by shli15 on 10/11/16.
 */
public class BinaryTreePathSum {
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        dfs(root, target, rst, list);
        return rst;
    }

    private void dfs(TreeNode root, int target, List<List<Integer>> rst, List<Integer> list) {
        if (root.left == null && root.right == null) {
            if (sum(list) == target) {
                rst.add(new ArrayList<Integer>(list));
            }

            if (root.left != null) {
                list.add(root.left.val);
                dfs(root.left, target, rst, list);
                list.remove(list.size() - 1);
            }

            if (root.right != null) {
                list.add(root.right.val);
                dfs(root.right, target, rst, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private int sum (List<Integer> list) {
        int sum = 0;
        for (int l : list) {
            sum += l;
        }

        return sum;
    }

    public static void main(String[] args) {
        BinaryTreePathSum BTPS = new BinaryTreePathSum();
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
        TreeNode two2 = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        root.left = two;
        root.right = four;
        two.left = two2;
        two.right = three;

        BTPS.binaryTreePathSum(root, 5);
        System.out.print("happy");
    }
}
