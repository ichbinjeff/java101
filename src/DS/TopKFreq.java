package DS;
import java.util.*;
import java.util.HashMap;

/**
 * Created by jli on 4/19/16.
 */
public class TopKFreq {
    private class Pair {
        String word;
        int count;

        public Pair(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        String[] rst = new String[k];
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String w : words) {
            if (map.containsKey(w)) {
                int v = map.get(w);
                map.put(w, v + 1);
            } else {
                map.put(w, 1);
            }
        }

        Comparator<Pair> comparator = new Comparator<Pair>() {
            public int compare(Pair o1, Pair o2) {
                if (o1.count == o2.count) {
                    return (o1.word.compareTo(o2.word));

                }
                return o2.count - o1.count;
            }
        };

        PriorityQueue<Pair> heap = new PriorityQueue<Pair>(map.size(), comparator);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            heap.add(new Pair(entry.getKey(), entry.getValue()));
        }

        int index = 0;
        while (!heap.isEmpty() && k > 0) {
            rst[index ++] = heap.poll().word;
            k --;
        }

        return rst;
    }

    public static void main(String[] args) {
        TopKFreq TKF = new TopKFreq();
        String[] list = TKF.topKFrequentWords(new String[]{"a","b","c","a","c"}, 2);
        System.out.print("ok");
    }
}
