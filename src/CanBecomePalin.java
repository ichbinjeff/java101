/**
 * Created by shli15 on 11/12/16.
 */
import java.util.Map;
import java.util.HashMap;

public class CanBecomePalin {
    String[] palindromize(String[] words) {
        String[] rst = new String[words.length];
        int index = 0;
        for (String w : words) {
            if (isPalindrome(w)) {
                rst[index++] = w;
            }
        }
        return rst;
    }

    // abba
    // abc
    boolean isPalindrome(String w) {
        int odd = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < w.length(); i++) {
            if (map.containsKey(w.charAt(i))) {
                map.put(w.charAt(i), map.get(w.charAt(i)) + 1);
            } else {
                map.put(w.charAt(i), 1);
            }
        }

        for (int v : map.values()) {
            if (v % 2 != 0) {
                odd ++;
            }
        }

        if (odd > 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] item = new String[] {"aaabbcccabb", "abba", "toyota"};
        CanBecomePalin ip = new CanBecomePalin();
        String[] rst = ip.palindromize(item);
        System.out.print("done");
    }
}