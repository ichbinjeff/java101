package Trie;

import java.util.HashMap;

/**
 * Created by shli15 on 11/28/16.
 */
public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode((char) 0);
    }
    // word
    public void insert(String word) {
        int length = word.length();
        TrieNode crawl = root;
        for (int level = 0; level < length; level ++) {
            HashMap<Character, TrieNode> child = crawl.children;
            char ch = word.charAt(level);
            if (child.containsKey(ch))
                crawl = child.get(ch);
            else {
                TrieNode temp = new TrieNode(ch);
                child.put(ch, temp);
                crawl = temp;
            }
        }
        crawl.bIsEnd = true;
    }

    public String getMatchingPrefix(String input) {
        String result = ""; // Initialize resultant string
        int length = input.length();  // Find length of the input string

        // Initialize reference to traverse through Trie
        TrieNode crawl = root;

        // Iterate through all characters of input string 'str' and traverse
        // down the Trie
        int level, prevMatch = 0;
        for( level = 0 ; level < length; level++ )
        {
            // Find current character of str
            char ch = input.charAt(level);

            // HashMap of current Trie node to traverse down
            HashMap<Character,TrieNode> child = crawl.children;

            // See if there is a Trie edge for the current character
            if( child.containsKey(ch) )
            {
                result += ch;          //Update result
                crawl = child.get(ch); //Update crawl to move down in Trie

                // If this is end of a word, then update prevMatch
                if( crawl.bIsEnd )
                    prevMatch = level + 1;
            }
            else  break;
        }

        // If the last processed character did not match end of a word,
        // return the previously matching prefix
        if( !crawl.bIsEnd )
            return result.substring(0, prevMatch);

        else return result;
    }

    public static void main(String[] args) {
        Trie dict = new Trie();
        dict.insert("are");
        dict.insert("area");
        dict.insert("base");
        dict.insert("cat");
        dict.insert("cater");
        dict.insert("basement");

        String input = "caterer";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));

        input = "basement";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));

        input = "are";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));

        input = "arex";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));

        input = "basemexz";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));

        input = "xyz";
        System.out.print(input + ":   ");
        System.out.println(dict.getMatchingPrefix(input));
    }
}
