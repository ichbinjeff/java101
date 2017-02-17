/**
 * Created by jli on 4/12/16.
 */
import java.util.*;

public class Colonist {
//    [1,2,3,3,3,2,1,7]
//    [1,2,3,2,3]

    public int[] matchTwoPoints(int[] women, int[] men) {
        int indexW = 0;
        int indexM = 0;
        int index = 0;
        Arrays.sort(women);
        Arrays.sort(men);

        int[] rst = women.length > men.length ? new int[women.length] : new int[men.length];
        while (indexW < women.length && indexM < men.length) {
            if (women[indexW] == men[indexM]) {
                rst[index ++] = men[indexM];
                indexW ++;
                indexM ++;
            } else if(women[indexW] < men[indexM]) {
                indexW ++;
            } else {
                indexM ++;
            }
        }

        return rst;
    }

    public int[] match(int[] women, int[] men) {
        int[] rst = women.length > men.length ? new int[women.length] : new int[men.length];
        Map<Integer, Integer> match = new HashMap<Integer, Integer>();
        for (int w : women) {
            if (match.containsKey(w)) {
                int count = match.get(w);
                match.put(w, count ++);
            } else {
                match.put(w, 1);
            }
        }

        int index = 0;
        for (int m : men) {
            if (match.containsKey(m) && match.get(m) > 0) {
                rst[index++] = m;
                int count = match.get(m);
                match.put(m, count --);
            }
        }

        return rst;
    }

    public int[] missingNum(int[] source, int[] dist) {
        int[] rst = new int[source.length];
        int index = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < source.length; i++) {
            if (map.containsKey(source[i])) {
                int count = map.get(source[i]);
                map.put(source[i], count + 1);
            } else {
                map.put(source[i], 1);
            }
        }

        for (int i = 0; i < dist.length; i++) {
            if (map.containsKey(dist[i]) && map.get(dist[i]) > 0) {
                int count = map.get(dist[i]);
                map.put(dist[i], count - 1);
            } else {
                rst[index ++] = dist[i];
            }
        }

        return rst;
    }

    public static void main(String[] args) {
        Colonist c = new Colonist();
        int[] women = new int[] {203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};
        int[] men = new int[] {203, 204, 205, 206, 207, 208, 203, 204 ,205 ,206};

//        int[] rst = c.match(women, men);
//        int[] rst2 = c.matchTwoPoints(women, men);
        c.missingNum(women, men);
        System.out.print("print");
    }
}
