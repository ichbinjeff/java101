package LinkedList;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by jli on 2/26/16.
 */
public class ReorderList {
    public ListNode findMid(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            head = head.next;
            fast = fast.next.next;
        }

        return head;
    }

    public void reorderList(ListNode head) {
        // write your code here
        ListNode mid = findMid(head);
        ListNode half = reverse(mid);
        ListNode dummy = head;

        while (dummy != null && half != null) {
            ListNode next = dummy.next;
            dummy.next = half;
            half.next = next;

            dummy = dummy.next;
            half = half.next;
        }

    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    // 1-2-3-4
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = null;

        ReorderList rd = new ReorderList();
        rd.reorderList(one);
    }
}
