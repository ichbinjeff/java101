/**
 * Created by jli on 10/26/15.
 */
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
//[
//    [2    ]
//    [3,4  ]
//    [5,6,7]
//    [8,2,4]
//]
    //[i, j]
    //[i + 1, j]
    //[i + 1, j + 1]

public class Triangle {
    private int search(int x, int y) {
        return 1;
    }

    private static int memorizeSearch(int[][] triangle) {

        return 1;
    }

    private static int miniTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return -1;
        }

        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }

        int n = triangle.length;
        int[][] f = new int[n][n];
        f[0][0] = triangle[0][0];

        // initialization
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][0] + triangle[i][0];
            f[i][i] = f[i - 1][i - 1] + triangle[i][i];
        }

        // build
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle[i][j];
            }
        }

        int best = f[n - 1][0];
        for (int i = 1; i < n; i++) {
            best = Math.min(best, f[n - 1][i]);
        }

        return best;

    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int[][] f = new int[triangle.size()][triangle.size()];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            f[i][0] = triangle.get(i).get(0) + f[i-1][0];
            f[i][i] = triangle.get(i).get(i) + f[i-1][i-1];
        }

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i-1][j-1], f[i-1][j]) + triangle.get(i).get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < f[f.length-1].length; i++) {
            min = Math.min(min, f[f.length-1][i]);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] row1 = new int[] {2};
        int[] row2 = new int[] {3, 4};
        int[] row3 = new int[] {5, 6, 7};
        int[] row4 = new int[] {8, 2, 4};

        int[][] triangle = new int[][] {row1, row2, row3, row4};
        List<Integer> r1 = new ArrayList<Integer>();
        r1.add(-1);
        List<Integer> r2 = new ArrayList<Integer>();
        r2.add(2);
        r2.add(3);
        List<Integer> r3 = new ArrayList<Integer>();
        r3.add(1);
        r3.add(-1);
        r3.add(-3);
        List<List<Integer>> t = new ArrayList<List<Integer>>();
        t.add(r1);
        t.add(r2);
        t.add(r3);
        //Triangle.miniTotal(triangle);
        Triangle.minimumTotal(t);
        System.out.print("done");

    }
}
