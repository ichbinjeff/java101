package LinkedList;

/**
 * Created by jli on 12/30/15.
 */
public class InsertionSortList {
    public ListNode is(ListNode head) {
        ListNode rst = new ListNode(0);
        while (head != null) {
            ListNode node = rst;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }

            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }
        return rst.next;
    }



    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        InsertionSortList ISL = new InsertionSortList();
        one.next = three;
        three.next = two;
        ListNode rst = ISL.is(one);
        System.out.print("haha");
    }
}
