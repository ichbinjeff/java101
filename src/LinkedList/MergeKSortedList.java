package LinkedList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by jli on 2/12/16.
 */
public class MergeKSortedList {
    private Comparator<ListNode> SortListComp = new Comparator<ListNode>() {
        public int compare(ListNode n1, ListNode n2) {
            if (n1 == null) {
                return 1;
            }

            if (n2 == null) {
                return -1;
            }

            return n1.val - n2.val;
        }
    };

    public ListNode mergeKsortedList(List<ListNode> sortedList) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(sortedList.size(), SortListComp);
        for (ListNode item : sortedList) {
            if (item != null) {
                heap.add(item);
            }
        }


        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            head.next = node;
            if (node.next != null) {
                heap.add(node.next);
            }
            head = head.next;
        }
        return dummy;
    }
}
