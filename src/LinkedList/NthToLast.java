package LinkedList;

import java.util.LinkedList;

/**
 * Created by jli on 12/3/15.
 */
public class NthToLast {
    public int nthToLast(ListNode head, int k) {
        if (head == null) {
            return 0;
        }
        int i = nthToLast(head.next, k) + 1;
        if (i == k) {
            System.out.print(head.val);
        }
        return i;
    }

    public ListNode nthToLast(ListNode head, int k, Counter i) {
        if (head == null) {
            return null;
        }

        ListNode node = nthToLast(head.next, k, i);
        i.value ++;
        if (i.value == k) {
            return head;
        }
        return node;
    }

    public ListNode nthToLast3(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (k > 0) {
            fast = fast.next;
            k --;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // 4-3-2-1
    public static void main(String[] args) {
        ListNode four = new ListNode(4);
        ListNode three = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode one = new ListNode(1);
        four.next = three;
        three.next = two;
        two.next = one;

        Counter i = new Counter();
        NthToLast n = new NthToLast();
        ListNode node = n.nthToLast3(four, 2);
        System.out.print(node.val);
    }

}
