package BinaryTree;

/**
 * Created by jli on 11/3/15.
 */
public class BalancedTree {
    public boolean isBalanced(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//
//        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
//            return false;
//        } else {
//            return isBalanced(root.left) && isBalanced(root.right);
//        }
        if(checkHeight(root) == -1) {
            return false;
        }
        return true;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public int checkHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
