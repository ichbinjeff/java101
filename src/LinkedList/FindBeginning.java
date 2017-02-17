package LinkedList;

/**
 * Created by jli on 12/1/15.
 */
public class FindBeginning {
    ListNode FindBeginning(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
