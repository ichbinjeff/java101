package LinkedList;

import java.util.LinkedList;

/**
 * Created by jli on 11/30/15.
 */
public class partition {
    public ListNode partition(ListNode node, int x) {
        ListNode beforeStart = null;
        ListNode beforeEnd = null;
        ListNode afterStart = null;
        ListNode afterEnd = null;

        while (node != null) {
            ListNode next = node.next;
            node.next = null;

            if (node.val < x) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                }
                else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            }
            else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }

        if (beforeStart == null) {
            return afterStart;
        }

        beforeStart.next = afterStart;
        return beforeStart;
    }

    public ListNode partition2(ListNode node, int x) {
        ListNode beforeStart = null;
        ListNode afterstart = null;

        while (node != null) {
            ListNode next = node.next;

            if (node.val < x) {
                node.next = beforeStart;
                beforeStart = node;
            } else {
                node.next = afterstart;
                afterstart = node;
            }

            node = next;
        }

        if (beforeStart == null) {
            return afterstart;
        }

        ListNode head = beforeStart;
        while (beforeStart.next != null) {
            beforeStart = beforeStart.next;
        }

        beforeStart.next = afterstart;
        return head;
    }

}
