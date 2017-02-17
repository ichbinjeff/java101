package DS;
import java.util.*;
/**
 * Created by jli on 4/19/16.
 */
public class LRUCache {

    int capacity;
    Map<Integer, Node> hash = new HashMap<Integer, Node>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!hash.containsKey(key)) {
            return -1;
        }

        Node element = hash.get(key);
        element.prev.next = element.next;
        element.next.prev = element.prev;

        moveToEnd(element);
        return element.value;
    }

    public void set(int key, int value) {
        if (get(key) != -1) {
            Node element = hash.get(key);
            element.value = value;
        }

        // if full, remove the first one
        if (hash.size() == capacity) {
            hash.remove(head.next.key);

            head.next = head.next.next;
            head.next.prev = head;
        }

        Node element = new Node(key, value);
        moveToEnd(element);
        hash.put(key, element);
    }

    public void moveToEnd(Node element) {
        Node tmp = tail.prev;
        tail.prev.next = element;
        element.next = tail;
        tail.prev = element;
        element.prev = tmp;
    }

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
}
