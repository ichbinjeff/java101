package LinkedList;

/**
 * Created by jli on 12/1/15.
 */
public class Reverse {
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reversed = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return reversed;
    }
    //1 2
//    1-prev
//    2-1
//    prev = 2
//    curr = 2
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Reverse r = new Reverse();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode newNode = r.reverseList(head);
        System.out.print("print");
    }

}
