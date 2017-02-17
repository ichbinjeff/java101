package LinkedList;

/**
 * Created by jli on 2/29/16.
 */
public class SwapNode {
    public ListNode swapPairs(ListNode head) {
        // Write your code here
//        ListNode dummy = new
        return null;
    }

    public ListNode swapNode(ListNode head, int v1, int v2) {
//        ListNode first = new ListNode(0), end = new ListNode(0);
//        ListNode rst = head;
//        while (head != null) {
//            if (v1 == 0) {
//                first = head;
//            }
//
//            if (v2 == 0) {
//                end = head;
//            }
//
//            head = head.next;
//            v1 --;
//            v2 --;
//        }
//
//        int temp = first.val;
//        first.val = end.val;
//        end.val = temp;
//
//        return rst;

        ListNode rst = new ListNode(0);
        rst.next = head;
        head = rst;

        ListNode first = head, end = head, beforeFirst = head, beforeEnd = head;
        while (head != null) {
            if (v1 == 1) {
                beforeFirst = head;
            }

            if (v2 == 1) {
                beforeEnd = head;
            }

            head = head.next;
            v1 --;
            v2 --;
        }

        first = beforeFirst.next;
        end = beforeEnd.next;

        beforeFirst.next = end;
        first.next = end.next;
        beforeEnd.next = first;
        end.next = beforeEnd;
        return rst.next;
    }

    public void insert(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        while (head.next != null) {
            head = head.next;
        }
        head.next = newNode;
    }

    public static void main(String[] args) {
        SwapNode SN = new SwapNode();
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int i = 1; i <= 4; i++) {
            SN.insert(curr, i);
        }
        ListNode rst = SN.swapNode(head.next, 2, 4);
        System.out.print("good");
    }



}
