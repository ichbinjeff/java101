package BinaryTree;
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by jli on 1/25/16.
 */
public class InOrder {
    public ArrayList<Integer> traverse(TreeNode root) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (root == null) {
            return rst;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while (curr != null || stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.peek();
            rst.add(stack.pop().val);
            curr = curr.right;
        }

        return rst;
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        System.out.print(root.val);
        System.out.print("\n");
        inOrder(root.right, list);
    }

    public static void main(String[] args) {
        InOrder IO = new InOrder();
        List<Integer> rst = new ArrayList<Integer>();
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(1);
        left.right = new TreeNode(4);
        root.left = left;
        TreeNode right = new TreeNode(5);
        root.right = right;
        IO.inOrder(root, rst);
    }
}
