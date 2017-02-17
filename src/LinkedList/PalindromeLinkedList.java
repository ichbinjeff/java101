package LinkedList;

/**
 * Created by jli on 12/1/15.
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode middle = findMiddle(head);
        middle.next = reverse(middle.next);

        ListNode p1 = head, p2 = middle.next;
        while (p1 != null && p2 != null && p1.val == p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2 == null;
    }

    public ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        ListNode reversed = reverse(next);
        head.next.next = head;
        head.next = null;

        return reversed;
    }

}
