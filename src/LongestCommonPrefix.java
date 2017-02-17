/**
 * Created by shli15 on 11/28/16.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String rst = strs[0];
        for (int i = 1; i < strs.length; i++) {
            rst = findLongest(rst, strs[i]);
        }
        return rst;
    }

    private String findLongest(String str1, String str2) {
        StringBuilder rst = new StringBuilder();
        int n = str1.length() > str2.length() ? str2.length() : str1.length();
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            rst.append(str1.charAt(i));
        }
        return rst.toString();
    }

    // gee
    // geek
    // gek
    public String longestCommonPrefixCbC(String[] strs) {
        StringBuilder rst = new StringBuilder();
        String pivot = strs[0];
        int start = 0;
        while (start < pivot.length()) {
            for (int i = 1; i < strs.length; i++) {
                if (start >= strs[i].length() || pivot.charAt(start) != strs[i].charAt(start)) {
                    return rst.toString();
                }
            }
            rst.append(pivot.charAt(start));
            start ++;
        }
        return rst.toString();
    }

}
