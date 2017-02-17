package DS;

/**
 * Created by shli15 on 5/11/16.
 */
public class Rehashing {
    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    // new hash function
    public int hashcode(int key, int capacity) {
        return key % capacity;
    }

    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        int len = hashTable.length;
        int newLen = len * 2;
        ListNode[] newHash = new ListNode[newLen];

        for (int i = 0; i < len; i++) {
            while (hashTable[i] != null) {
                int newIndex = (hashTable[i].val % newLen + newLen) % newLen;
                if (newHash[newIndex] == null) {
                    newHash[newIndex] = new ListNode(hashTable[i].val);
                } else {
                    ListNode dummy = newHash[newIndex];
                    while (dummy.next != null) {
                        dummy = dummy.next;
                    }
                    dummy.next = new ListNode(hashTable[i].val);
                }
                hashTable[i] = hashTable[i].next;
            }
        }

        return newHash;

    }
}
