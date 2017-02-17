import java.util.Set;
/**
 * Created by shli15 on 6/28/16.
 */
//public class archive {
//    public int maxLength (Set<String> dict) {
//        int max = 0;
//        for (String item : dict) {
//            if (item.length() > max) {
//                max = item.length();
//            }
//        }
//
//        return max;
//    }
//
//    public boolean wordBreak(String s, Set<String> dict) {
//        // write your code here
//        int maxLen = maxLength(dict);
//        boolean[] f = new boolean[s.length() + 1];
//        f[0] = true;
//
//        for (int i = 1; i <= s.length(); i++) {
//            for (int lastWordLen = 1; lastWordLen <= maxLen && i - lastWordLen >= 0; lastWordLen++) {
//                if (!f[i - lastWordLen]) {
//                    continue;
//                }
//
//                boolean temp = isWord(s, dict, i - lastWordLen, i);
//                if (temp) {
//                    f[i] = temp;
//                    break;
//                }
//            }
//        }
//
//        return f[s.length()];
//    }
//
//    public boolean isWord(String s, Set<String> dict, int start, int end) {
//        String sub = s.substring(start, end);
//        if (dict.contains(sub)) {
//            return true;
//        }
//
//        return false;
//    }


//        if (A == null || B == null || A.length() < B.length()) {
//        return false;
//        }
//        if (B.length() == 0) {
//        return true;
//        }
//
//        int[] charSet = new int[26];
//        for (int i = 0; i < A.length(); i++) {
//        charSet[A.charAt(i) - 'A'] ++;
//        }
//
//        for (int i = 0; i < B.length(); i++) {
//        charSet[B.charAt(i) - 'A'] --;
//        if (charSet[B.charAt(i) - 'A'] < 0) {
//        return false;
//        }
//        }
//        return true;

//}
