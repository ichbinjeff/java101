package fundamental;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;
/**
 * Created by shli15 on 9/19/16.
 */
public class Learn {
    public static void main(String[] args) {
        // HASHMAP
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);

        int size = map.size();
        boolean value = map.containsValue(2);
        boolean key = map.containsKey(2);

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(":");
            System.out.print(entry.getValue());
            System.out.print("\n");
        }

        Map<Integer, List<Integer>> listMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < 10; i++) {
            List temp = new LinkedList<Integer>();
            temp.add(i);
            listMap.put(i, temp);
        }

        listMap.get(3).add(3000);

        for (Map.Entry<Integer, List<Integer>> entry : listMap.entrySet()) {
            StringBuffer sb = new StringBuffer();
            List<Integer> temp = entry.getValue();
            for (int i = 0; i < temp.size(); i++) {
                sb.append(temp.get(i));
                if (i != temp.size() - 1) {
                    sb.append("-");
                }
            }
            System.out.print(sb.toString());
            System.out.print("\n");


        }

        // HASHSET


    }
}
