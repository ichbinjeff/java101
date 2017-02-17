package BinaryTree;

/**
 * Created by shli15 on 10/12/16.
 */
public class CompleteBinaryTree {
    public boolean isComplete(TreeNode root) {
        // Write your code here
        int height = getHeight(root);
        return helper(root, 1, height, false);
    }

    private boolean helper(TreeNode root, int level, int height, boolean direction) {
        if (root == null) {
            return true;
        }

        if (root.left == null && level != height && direction) {
            return false;
        }

        if (level == height) {
            return true;
        }

        boolean rst = helper(root.left, level + 1, height, false)
                && helper(root.right, level + 1, height, true);

        return rst;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public static void main(String[] args) {
        CompleteBinaryTree CBT = new CompleteBinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode four = new TreeNode(4);
//        TreeNode two2 = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        root.left = two;
        root.right = three;
        two.left = four;


        boolean rst = CBT.isComplete(root);
        System.out.print("done");
    }
}
