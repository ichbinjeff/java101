package DS;
import java.util.Map;
import java.util.HashMap;
/**
 * Created by shli15 on 12/16/16.
 */
public class LRU {
    private int capacity;
    private Map<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);
    private Node end = new Node(-1, -1);
    // @param capacity, an integer
    public LRU(int capacity) {
        // write your code here
        this.capacity = capacity;
        end.prev = head;
        head.next = end;
    }

    // @return an integer
    public int get(int key) {
        // write your code here
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            moveToFirst(n);
            return n.value;
        } else {
            return -1;
        }
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.value = value;
            remove(n);
            moveToFirst(n);
        } else {
            if (map.size() >= capacity) {
                removeLeast();
            }
            Node n = new Node(key, value);
            moveToFirst(n);
            map.put(key, n);
        }
    }

    // 1<->2<->3
    private void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void moveToFirst(Node n) {
        n.next = end;
        n.prev = end.prev;
        end.prev.next = n;
        end.prev = n;
    }

    private void removeLeast() {
        Node least = head.next;
        map.remove(least.key);

        head.next = least.next;
        least.next.prev = head;
        least.prev = null;
        least.next = null;
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

