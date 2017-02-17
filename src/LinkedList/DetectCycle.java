package LinkedList;

/**
 * Created by shli15 on 5/11/16.
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow != fast) {
            return null;
        }

        fast = head;
        slow = slow.next;
        while (fast != null) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(3);
        ListNode two = new ListNode(4);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next= three;
        three.next = two;

        DetectCycle DC = new DetectCycle();
        DC.detectCycle(one);
    }
}
