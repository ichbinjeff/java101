package LinkedList;

import java.util.List;

/**
 * Created by jli on 1/25/16.
 */
public class AddTwoNum {
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        return helper(l1, l2, 0);
    }

    public ListNode helper(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int sum = carry;
        if (l1 != null) {
            sum += l1.val;
        }

        if (l2 != null) {
            sum += l2.val;
        }

        int val = sum % 10;

        ListNode current = new ListNode(val);
        ListNode more = helper(l1 == null || l1.next == null ? null : l1.next,
                l2 == null || l2.next == null ? null : l2.next,
                sum / 10);
        current.next = more;

        return current;
    }

    public static void main(String[] args) {
        ListNode three = new ListNode(3);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);

        ListNode l1 = three;
        three.next = one;
        one.next = two;

        ListNode funf = new ListNode(5);
        ListNode neu = new ListNode(9);
        ListNode funf2 = new ListNode(5);
        ListNode ein = new ListNode(1);

        funf.next = neu;
        neu.next = funf2;
        funf2.next = ein;

        ListNode l2 = funf;
        AddTwoNum adt = new AddTwoNum();
        ListNode rst = adt.addLists(l1, l2);
        System.out.print(rst.val);

    }
}
