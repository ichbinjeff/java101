package DP;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
/**
 * Created by jli on 1/25/16.
 */
public class WordBreak {
        public int maxLength (Set<String> dict) {
            int max = 0;
            for (String item : dict) {
                if (item.length() > max) {
                    max = item.length();
                }
            }

            return max;
        }

        public boolean wordBreak(String s, Set<String> dict) {
            // write your code here
            int maxLen = maxLength(dict);
            boolean[] f = new boolean[s.length() + 1];
            f[0] = true;

            for (int i = 1; i <= s.length(); i++) {
                for (int lastWordLen = 1; lastWordLen <= maxLen && i - lastWordLen >= 0; lastWordLen++) {
                    if (!f[i - lastWordLen]) {
                        continue;
                    }

                    boolean temp = isWord(s, dict, i - lastWordLen, i);
                    if (temp) {
                        f[i] = temp;
                        break;
                    }
                }
            }

            return f[s.length()];
        }

        public boolean isWord(String s, Set<String> dict, int start, int end) {
            String sub = s.substring(start, end);
            if (dict.contains(sub)) {
                return true;
            }

            return false;
        }

        public static void main(String[] args) {
            WordBreak wb = new WordBreak();
            Set<String> testset = new HashSet<String>();
            testset.add("bc");
            testset.add("cd");
            testset.add("de");
            testset.add("fg");
            testset.add("abcd");
            testset.add("efg");


            boolean rst = wb.wordBreak("abcdefg", testset);
            System.out.print(rst);
        }

    }
