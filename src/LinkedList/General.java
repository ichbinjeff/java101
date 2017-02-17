package LinkedList;

import java.util.HashSet;
import java.util.Set;
import BinaryTree.TreeNode;
import apple.laf.JRSUIUtils;

/**
 * Created by jli on 2/2/16.
 */
public class General {
    // remove dup from unsorted list
    public ListNode removeDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        Set<Integer> listSet = new HashSet<Integer>();

        while (head != null && head.next != null) {
            if (listSet.contains(head.next.val)) {
                head.next = head.next.next;
            } else {
                listSet.add(head.next.val);
                head = head.next;
            }
        }

        return dummy.next;
    }

    public ListNode swapNode(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null && head.next.next != null) {
            head.next.next = head.next;
        }
        return null;

    }

    public ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = null;

        while (head != null && head.next != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public ListNode reverse2(ListNode head) {
             if (head == null || head.next == null) {
                 return head;
             }

             ListNode reversed = reverse2(head.next);
        head.next.next = head;
        head.next = null;

        return reversed;
    }

    public ListNode reverseii(ListNode head, int m, int n) {
        if (m >= n || head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }

        ListNode preMNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode, postNNode = mNode.next;

        for (int i = m; i < n; i++) {
            if (postNNode == null) {
                return null;
            }

            ListNode next = postNNode.next;
            postNNode.next = nNode;
            nNode = postNNode;
            postNNode = next;
        }

        mNode.next = postNNode;
        preMNode.next = nNode;
        return dummy.next;

    }

    public void sortLinkedList(ListNode head) {

    }

    public ListNode findMiddle(ListNode start, ListNode end) {
        ListNode fast = start;
        ListNode slow = start;

        while (fast.next != end && fast.next.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }





}