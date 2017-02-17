package BinaryTree;

/**
 * Created by jli on 11/5/15.
 */
public class LeastCommonAncester {
    public TreeNode leastCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode left = leastCommonAncestor(root.left, p, q);
        TreeNode right = leastCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        if (right != null) {
            return right;
        }

        return null;
    }
}
