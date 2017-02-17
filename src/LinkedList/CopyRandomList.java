package LinkedList;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by jli on 2/8/16.
 */
public class CopyRandomList {
    private class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode first = head;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        while (head != null) {
            map.put(head, new RandomListNode(head.label));
            head = head.next;
        }

        head = first;
        while (head != null) {
            RandomListNode newNode = map.get(head);
            newNode.next = map.get(head.next);
            if (head.random != null) {
                newNode.random = map.get(head.random);
            }

            map.put(head, newNode);
            head = head.next;
        }

        return map.get(first);
    }
}
