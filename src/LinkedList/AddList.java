package LinkedList;


/**
 * Created by jli on 11/30/15.
 */
public class AddList {
    public ListNode addList(ListNode n1, ListNode n2, int carry) {
        int value = carry;
        if (n1 == null && n2 == null && carry == 0) {
            return null;
        }

        ListNode rst = new ListNode(0);
        if (n1 != null) {
            value += n1.val;
        }

        if (n2 != null) {
            value += n2.val;
        }

        rst.val = value % 10;
        ListNode more = this.addList(n1.next == null ? n1.next : null, n2.next == null ? n2.next : null, carry >= 10 ? 1 : 0);
        rst.next = more;

        return rst;
    }

    public ListNode addList2(ListNode l1, ListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);

        if (len1 < len2) {
            l1 = padList(l1, len2 - len1);
        } else {
            l2 = padList(l2, len1 - len2);
        }
        PartialSum sum = addListHelper(l1, l2);
        if (sum.carry == 0) {
            return sum.sum;
        } else {
            ListNode rst = insertBefore(sum.sum, sum.carry);
            return rst;
        }
    }

    public PartialSum addListHelper(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            PartialSum sum = new PartialSum();
            return sum;
        }

        PartialSum sum = addListHelper(l1.next, l2.next);
        int val = sum.carry + l1.val + l2.val;
        ListNode rst = insertBefore(sum.sum, val % 10);
        sum.sum = rst;
        sum.carry = val / 10;
        return sum;
    }

    public ListNode insertBefore(ListNode list, int val) {
        ListNode node = new ListNode(val);
        if (list != null) {
            node.next = list;
        }
        return node;
    }

    public ListNode padList(ListNode l, int pad) {
        ListNode h = l;
        for (int i = 0; i < pad; i++) {
            ListNode n = new ListNode(0);
            n.next = h;
            h = n;
        }
        return h;
    }

    public int length(ListNode l) {
        int count = 0;
        while (l != null) {
            count ++;
            l = l.next;
        }
        return count;
    }

}
