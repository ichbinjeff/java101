/**
 * Created by jli on 10/30/15.
 */
public class CompareString {
    public static boolean compareStrings(String A, String B) {
        // write your code here
        if (A == null || B == null || A.length() < B.length()) {
            return false;
        }
        if (B.length() == 0) {
            return true;
        }

        int[] charSet = new int[26];
        for (int i = 0; i < A.length(); i++) {
            charSet[A.charAt(i) - 'A'] ++;
        }

        for (int i = 0; i < B.length(); i++) {
            charSet[B.charAt(i) - 'A'] --;
            if (charSet[B.charAt(i) - 'A'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String A = "ABBC";
        String B = "BBCD";

        CompareString.compareStrings(A, B);
    }
}

