package LinkedList;

/**
 * Created by jli on 2/2/16.
 */
public class RemoveNthFromEnd {
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = head;
        ListNode slow = head;

        int c = n;
        while (fast != null && c > 0) {
            fast = fast.next;
            c --;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = null;
        return dummy.next;
    }
}
