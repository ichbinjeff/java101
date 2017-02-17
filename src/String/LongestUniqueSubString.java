package String;
import java.util.Set;
import java.util.HashSet;
/**
 * Created by shli15 on 11/22/16.
 */
public class LongestUniqueSubString {
    public int longestUniqueSubstr(String s) {
        int maxLen = 1;
        int currLen = 1;
        int[] visited = new int[256];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = -1;
        }
        visited[s.charAt(0)] = 0;
        for (int i = 1; i < s.length(); i++) {
            int prevIndex = visited[s.charAt(i)];
            if (prevIndex == -1 || i - currLen > prevIndex) {
                currLen ++;
            } else {
                maxLen = Math.max(currLen, maxLen);
                currLen = i - prevIndex;
            }
            visited[s.charAt(i)] = i;
        }
        return maxLen;
    }

    //abcabcbb
    public int longestUniqueSub(String s) {
        int maxLen = 1;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String sub = s.substring(i, j);
                if (isUnique(sub) && j - i > maxLen) {
                    maxLen = j - i;
                }
            }
        }

        return maxLen;
    }

    public int longestUniqueSubEnumerate(String s) {
        //abcabc
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            int currLen = 1;
            Set<Character> set = new HashSet<Character>();
            int j = i;
            while (j + 1 < s.length()
                    && s.charAt(j) != s.charAt(j + 1)
                    && !set.contains(s.charAt(j + 1))) {
                currLen ++;
                set.add(s.charAt(j));
                j ++;
            }
            maxLen = Math.max(currLen, maxLen);
        }
        return maxLen;
    }

    private boolean isUnique(String s) {
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        LongestUniqueSubString LS = new LongestUniqueSubString();
        LS.longestUniqueSubstr("abcabcbb");
        int len = LS.longestUniqueSub("abcdefabcd");
        int len2 = LS.longestUniqueSubEnumerate("abcdab");
        System.out.print("haha" + len + "haha" + len2);
    }
}
