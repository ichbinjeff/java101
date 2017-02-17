/**
 * Created by jli on 10/30/15.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        // Write your code here
        String oldString = "1";
        for (int k = 2; k <= n; k++) {
            char[] set = oldString.toCharArray();
            StringBuilder sb = new StringBuilder();

            int count = 1;

            for (int j = 0; j < set.length; j++) {
                while (j + 1 < set.length && set[j] == set[j + 1]) {
                    count ++;
                    j ++;
                }
                sb.append(String.valueOf(count) + String.valueOf(set[j]));
            }
            oldString = sb.toString();
        }

        return oldString;
    }
}