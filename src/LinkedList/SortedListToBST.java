package LinkedList;

import BinaryTree.TreeNode;

/**
 * Created by jli on 2/4/16.
 */


public class SortedListToBST {
    public ListNode curr;
    // 1->2->3->null
    public int length(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }

        return count;
    }

    public TreeNode helper(int length) {
        if (length <= 0) {
            return null;
        }
        TreeNode left = helper(length / 2);
        TreeNode root = new TreeNode(curr.val);
        curr = curr.next;
        TreeNode right = helper(length - 1 - length / 2);

        root.left = left;
        root.right = right;

        return root;
    }

}
