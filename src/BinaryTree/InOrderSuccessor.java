package BinaryTree;

/**
 * Created by jli on 10/26/15.
 */
public class InOrderSuccessor {
    // [2, 1, 3]
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null && root.val != p.val) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        if (root == null) {
            return null;
        }

        if (root.right == null) {
            return successor;
        }

        root = root.right;
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

}
