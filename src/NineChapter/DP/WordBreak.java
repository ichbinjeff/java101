package NineChapter.DP;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Created by shli15 on 6/28/16.
 */
//TODO
public class WordBreak {
    // "aaab", ["b","aa"]
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if (s.isEmpty() && dict.isEmpty()) {
            return true;
        }

        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        // ping pong
        int len = maxLen(dict);
        for (int i = 1; i <= s.length(); i++) {
            for (int start = 1; start <= i && i - start >= 0; start++) {
                if (!f[start]) {
                    continue;
                }

                boolean temp = f[start] && inDictionary(s, start, i, dict);
                if (temp) {
                    f[i] = temp;
                    break;
                }
            }
        }

        return f[s.length()];
    }

    public int maxLen(Set<String> dict) {
        int len = 0;
        for (String item: dict) {
            len = Math.max(item.length(), len);
        }

        return len;
    }

    public boolean inDictionary(String s, int start, int end, Set<String> dict) {
        String sub = s.substring(start, end);
        return dict.contains(sub);
    }

    public static void main(String[] args) {
        String teststr = "a";
        Set<String> set = new HashSet<String>();
        //set.add("b");
        set.add("a");

        WordBreak wb = new WordBreak();
        boolean rst = wb.wordBreak(teststr, set);
        System.out.print(rst);
    }
}
