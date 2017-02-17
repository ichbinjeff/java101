package BinaryTree; /**
 * Created by jli on 11/4/15.
 */
import java.util.ArrayList;

public class IsBinarySearchTree {
    // naive solution, in-order traversal
    // do a sort
    public void inOrder(TreeNode root, ArrayList<Integer> rst) {
        if (root == null) {
            return;
        }

        inOrder(root.left, rst);
        rst.add(root.val);
        inOrder(root.right, rst);
    }

    public ArrayList<Integer> inorderDC(TreeNode root) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }

        ArrayList<Integer> left = inorderDC(root.left);
        ArrayList<Integer> right = inorderDC(root.right);

        rst.addAll(left);
        rst.add(root.val);
        rst.addAll(right);

        return rst;
    }


    public boolean checkBST(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        inOrder(root, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i - 1) >= arr.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static int last_printed = Integer.MIN_VALUE;
    public static boolean checkBSTDC(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!checkBSTDC(root.left)) {
            return false;
        }

        if (root.val < last_printed) {
            return false;
        }
        last_printed = root.val;

        if (!checkBSTDC(root.right)) {
            return false;
        }

        return true;
    }

    public static boolean checkBSTDC2(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.val < min || root.val > max) {
            return false;
        }

        if (!checkBSTDC2(root.left, min, root.val) || !checkBSTDC2(root.right, root.val, max)) {
            return false;
        }

        return true;
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

        IsBinarySearchTree ibt = new IsBinarySearchTree();
        ArrayList result = ibt.inorderDC(one);
        System.out.print("jfdklfjlsd");
    }



}
