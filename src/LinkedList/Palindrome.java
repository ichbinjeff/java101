package LinkedList;

/**
 * Created by jli on 12/1/15.
 */
public class Palindrome {
    public boolean reverseAndCompare(ListNode head) {
        ListNode curr = head;

        int len = length(head);
        int mid = len / 2;
        ListNode reversed = reverse(head);

        for (int i = 0; i < mid; i++) {
            if (curr.val != reversed.val) {
                return false;
            }
            curr = curr.next;
            reversed = reversed.next;
        }
        return true;
    }

    public ListNode reverse(ListNode l) {
//        LinkedListNode node = head;
//        if (node == null || node.next == null) {
//            return node;
//        }
//
//        LinkedListNode next = node.next;
//        LinkedListNode reversed = reverse(next);
//        node.next.next = head;
//        node.next = null;
//        return reversed;
        ListNode prev = null;
        while (l != null) {
            ListNode next = l.next;
            l.next = prev;
            prev = l;
            l = next;
        }
        return prev;
    }

    public int length(ListNode head) {
        int count = 0;
        while (head != null) {
            count ++;
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode iii = new ListNode(3);
        ListNode iv = new ListNode(4);

        three.next = four;
        four.next = iv;
        iv.next = iii;

        Palindrome pal = new Palindrome();
        pal.reverseAndCompare(three);
    }

}
