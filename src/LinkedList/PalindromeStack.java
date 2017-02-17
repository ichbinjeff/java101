package LinkedList;

import java.util.Stack;

/**
 * Created by jli on 12/1/15.
 */
public class PalindromeStack {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        Stack<Integer> stack = new Stack<Integer>();

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != stack.pop()) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }


}

