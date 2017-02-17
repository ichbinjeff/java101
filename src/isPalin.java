/**
 * Created by jli on 4/17/16.
 */
import java.util.*;
public class isPalin {
    static String[] palindromize(String[] words) {
        String[] rst = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            Map<Character, Integer> count = new HashMap<Character, Integer>();
            String item = words[i];

            for (int j = 0; j < item.length(); j++) {
                char l = item.charAt(j);
                if (count.containsKey(l)) {
                    int num = count.get(l);
                    count.put(l, num + 1);
                } else {
                    count.put(l, 1);
                }
            }


            String pair = "";
            String only = "";
            Boolean first = true;
            Boolean inValid = false;

            Iterator<Map.Entry<Character, Integer>> countIt = count.entrySet().iterator();
            while (countIt.hasNext()) {
                Map.Entry<Character, Integer> entry = countIt.next();
                if (entry.getValue() % 2 == 1) {
                    if (first) {
                        int n = entry.getValue();
                        Character v = entry.getKey();
                        while (n > 0) {
                            n--;
                            only += v;
                        }
                        first = false;
                    } else {
                        inValid = true;
                        break;
                    }
                } else {
                    int n = entry.getValue() / 2;
                    Character v = entry.getKey();
                    while (n > 0) {
                        n--;
                        pair += v;
                    }
                }
            }

            if (!inValid) {
                rst[i] = pair + only + reverse(pair);
            } else {
                rst[i] = "-1";
            }

        }

        return rst;
    }

    public static String reverse(String value) {
        String newValue = "";
        for (int i = value.length() - 1; i >= 0; i --) {
            newValue += value.charAt(i);
        }

        return newValue;
    }

    public static void main(String[] args) {
        String[] item = new String[] {"aaabbcccabb", "abba", "toyota"};
        isPalin ip = new isPalin();
        String[] rst = ip.palindromize(item);
        System.out.print("done");
    }
}
