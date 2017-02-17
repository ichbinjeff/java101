package String;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by shli15 on 12/4/16.
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        return minimumTotal(triangle, 0, 0);
    }

    private int minimumTotal(List<List<Integer>> triangle, int i, int j) {
        int curr = triangle.get(i).get(j);
        if (i + 1 > triangle.size()
                || j + 1 > triangle.get(0).size()) {
            return curr;
        }
        return Math.min(minimumTotal(triangle, i + 1, j),
                minimumTotal(triangle, i + 1, j + 1)) + curr;
    }

    public static void main(String[] args) {
        List<Integer> tst1 = new ArrayList<Integer>();
        tst1.add(2);
        tst1.add(3);
        List<Integer> tst2 = new ArrayList<Integer>();
        tst2.add(1);

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(tst2);
        list.add(tst1);
        MinimumTotal MT = new MinimumTotal();
        int rst = MT.minimumTotal(list);
        System.out.print(rst);
    }
}
