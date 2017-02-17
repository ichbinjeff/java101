package BinaryTree;

import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

/**
 * Created by shli15 on 10/2/16.
 */
public class LCAIII {
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (isValid(root, A) && isValid(root, B)) {
            return LCA(root, A, B);
        }

        return null;
    }

    public boolean isValid(TreeNode root, TreeNode sub) {
        if (root == null) {
            return false;
        }

        if (root == sub) {
            return true;
        }

        return isValid(root.left, sub) || isValid(root.right, sub);

    }

    private TreeNode LCA(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;
        }

        if (root == A || root == B) {
            return root;
        }

        TreeNode left = LCA(root.left, A, B);
        TreeNode right = LCA(root.right, A, B);

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

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(-2);
        TreeNode l = new TreeNode(1);
        TreeNode r = new TreeNode(3);
        t1.left = l;
        t1.right = r;
        LCAIII lca = new LCAIII();
        boolean rst = lca.isValid(t1, l);
        boolean rst2 = lca.isValid(t1, r);
        System.out.print(rst);
        System.out.print(rst2);
        TreeNode rt = lca.lowestCommonAncestor3(t1, l, r);
        System.out.print(rst2);

    }
}
