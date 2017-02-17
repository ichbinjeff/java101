package String;
import java.util.Map;
import java.util.HashMap;
/**
 * Created by shli15 on 9/21/16.
 */
public class SingleNumber {
    public int singleNumberII(int[] A) {
        // write your code here
        // [1,1,1,2,2,2,3,3,3,4]
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for (int a : A) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (!entry.getValue().equals(3)) {
                return (int)entry.getKey();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SingleNumber SN = new SingleNumber();
    }
}
