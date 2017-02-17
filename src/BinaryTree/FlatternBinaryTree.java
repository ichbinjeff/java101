package BinaryTree;

/**
 * Created by jli on 10/30/15.
 */

public class FlatternBinaryTree {
    private TreeNode lastNode = null;


    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }

        lastNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }

    public void flattenDC(TreeNode root) {
        flatterHelper(root);
    }

    public TreeNode flatterHelper(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        }

        if (root.left == null) {
            return flatterHelper(root.right);
        }

        if (root.right == null) {
            root.right = root.left;
            root.left = null;
            return flatterHelper(root.right);
        }

        TreeNode leftMost = flatterHelper(root.left);
        TreeNode rightMost = flatterHelper(root.right);

        leftMost.right = root.right;
        root.right = root.left;
        root.left = null;
        return rightMost;
    }

    public static void main(String[] args) {
        TreeNode six = new TreeNode(6);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        TreeNode five = new TreeNode(5);

        one.left = two;
        one.right = five;
        two.left = three;
        two.right = four;
        five.right = six;

        FlatternBinaryTree Fbt = new FlatternBinaryTree();
        Fbt.flattenDC(one);

    }

}
