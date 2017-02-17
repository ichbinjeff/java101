package LinkedList;

/**
 * Created by jli on 2/2/16.
 */
public class RemoveDup {
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        while (dummy.next != null) {
            if (dummy.val == dummy.next.val) {
                dummy.next = dummy.next.next;
            } else {
                dummy = dummy.next;
            }
        }

        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int val = head.next.val;
                while (head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }
            } else{
                head = head.next;
            }
        }

        return dummy.next;
    }
}
