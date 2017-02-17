package LinkedList;

/**
 * Created by jli on 2/15/16.
 */
public class OddEven {
    public ListNode oddEven(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode odd = head, even = head, evenFirst = head;
        while (head != null && head.next != null) {
            odd.next = head.next.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;

            head = head.next;
        }

        odd.next = evenFirst;
        return dummy.next;
    }
}
