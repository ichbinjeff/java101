/**
 * Created by jli on 4/18/16.
 */
import java.util.*;

public class processPalin {
    static String[] palindromize(String[] words) {
        String[] rst = new String[words.length];
        int index = 0;
        for (String w : words) {
            Map<Character, Integer> count = new HashMap<Character, Integer>();
            for (int i = 0; i < w.length(); i++) {
                if (count.containsKey(w.charAt(i))) {
                    int num = count.get(w.charAt(i));
                    count.put(w.charAt(i), num + 1);
                } else {
                    count.put(w.charAt(i), 1);
                }
            }

            Iterator<Map.Entry<Character, Integer>> it = count.entrySet().iterator();
            String pair = "";
            String odd = "";

            while (it.hasNext()) {
                Map.Entry<Character, Integer> entry = it.next();
                char k = entry.getKey();
                int v = entry.getValue();
                int  freq = 1;
                if (v % 2 == 1) {
                    if (freq > 1) {
                        rst[index ++] = "-1";
                        break;
                    } else {
                        odd += k;
                    }
                    freq ++;
                } else {
                    int n = v / 2;
                    while (n > 0) {
                        pair += k;
                        n --;
                    }
                }

            }

        }

        return rst;
    }
}
