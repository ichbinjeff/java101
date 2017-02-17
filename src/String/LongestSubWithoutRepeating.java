package String;

/**
 * Created by shli15 on 12/19/16.
 */
public class LongestSubWithoutRepeating {
    public int lengthOfLongest(String s) {
        if (s == null || s.length() == 0) return 0;
        int max = 0;
        int head = 0, curr = 0;
        int[] sTable = new int[256];
        int repeat = 0;
        while (curr < s.length()) {
            if (sTable[s.charAt(curr++)]++ > 0) repeat++;
            while (repeat > 0) {
                if (sTable[s.charAt(head++)]-- > 1) {
                    repeat --;
                }
            }
            max = Math.max(max, curr - head);
        }
        return max;
    }
}
