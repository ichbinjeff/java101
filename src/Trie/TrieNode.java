package Trie;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by shli15 on 11/28/16.
 */
public class TrieNode {
    char value;
    HashMap<Character, TrieNode> children;
    boolean bIsEnd;

    public TrieNode(char ch) {
        value = ch;
        children = new HashMap<Character, TrieNode>();
        bIsEnd = false;
    }
}
