package String;

/**
 * Created by shli15 on 12/4/16.
 */
public class PrefixPalindrome {
    private String shortestPalndrome(String s, int l, int r) {
        if (l == r) return "";
        if (l + 1 == r) return s.charAt(r) + s;
        if (s.charAt(l) == s.charAt(r)) {
            return s.charAt(l) + shortestPalndrome(s, l + 1, r - 1) + s.charAt(r);
        } else {
            String left = shortestPalndrome(s, l + 1, r);
            String right = shortestPalndrome(s, l, r - 1);
            if (left.length() < right.length()) {
                return left + s;
            } else {
                return right + s;
            }
        }
    }

    public static void main(String[] args) {
        PrefixPalindrome PP = new PrefixPalindrome();
        String rst = PP.shortestPalndrome("abc", 0, 2);
        System.out.print(rst);
    }
}
