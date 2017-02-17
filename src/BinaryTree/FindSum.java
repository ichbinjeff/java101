package BinaryTree;

/**
 * Created by jli on 11/5/15.
 */
public class FindSum {
    public void findSum(TreeNode node, int sum) {
        if (node == null) {
            return;
        }

        int[] path = new int[getHeight(node)];
        findSum(node, sum, path, 0);
    }

    public void findSum(TreeNode node, int sum, int[] path, int level) {
        if (node == null) {
            return;
        }

        path[level] = node.val;
        int total = 0;
        for (int i = level; i >= 0; i--) {
            total += path[i];
            if (total == sum) {
                print(path, i, level);
            }
        }
        findSum(node.left, sum, path, level + 1);
        findSum(node.right, sum, path, level + 1);
    }

    public void print(int[] path, int start, int end) {
        StringBuilder rst = new StringBuilder();
        for (int i = start; i <= end; i++) {
            rst.append(path[i]);
            rst.append(" ");
        }
        System.out.print(rst.toString());
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        }
    }

}
