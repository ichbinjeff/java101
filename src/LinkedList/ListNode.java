package LinkedList;

/**
 * Created by jli on 11/30/15.
 */
public class ListNode {
    ListNode next;
    int val;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
