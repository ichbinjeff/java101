package DP;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by shli15 on 6/19/16.
 */
public class Backpack {
    // full back pack
    public int backPack(int m, int[] A) {
        // write your code here
        int[][] f = new int[A.length][m + 1];
        for(int i = 0; i < A.length; i++) {
            for (int j = m; j >= 0; j--) {
                f[i][j] = Integer.MIN_VALUE;
            }
        }
        f[0][0] = 0;
        for (int i = 1; i < A.length; i++) {
            for (int j = m; j > 0; j--) {
                System.out.print("i=" + i);
                System.out.print("j=" + j);
                if(j - A[i] >= 0) {
                    f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - A[i]] + A[i]);
                } else {
                    f[i][j] = f[i - 1][j];
                }

            }
        }

        return f[A.length - 1][m];
    }

    public int backpackComplete(int m, int[] A) {
        int [] f = new int[m + 1];
        for (int i = 0; i <= m; i++) {
            f[i] = 0;
        }

        for (int i = 1; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                if (j >= A[i - 1]) {
                    f[j] = f[j - A[i - 1]] + A[i - 1];
                }
            }
        }

        return f[m];
    }

    public List<List<Integer>> backPackDetail(int m, int[] A) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();

        dfs(rst, list, A, m);
        return rst;
    }

    private void dfs(List<List<Integer>> rst, List<Integer> list, int[] A, int m) {
        if (sum(list) > m) {
            return;
        }

        if (sum(list) == m) {
            rst.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < A.length; i++) {
            list.add(A[i]);
            dfs(rst, list, A, m);
            list.remove(list.size() - 1);
        }
    }

    private int sum(List<Integer> list) {
        int count = 0;
        for (int i : list) {
            count += i;
        }

        return count;
    }


//    private List<List<Integer>> dfsDC(List<Integer> list, int[] A, int m) {
//        List<List<Integer>> rst = new ArrayList<List<Integer>>();
//        if (sum(list) > m) {
//            return rst;
//        }
//
//        if (sum(list) == m) {
//            rst.add(new ArrayList<Integer>(list));
//            return;
//        }
//
//        for (int i = 0; i < A.length; i++) {
//            list.add(A[i]);
//            dfs(rst, list, A, m);
//            list.remove(list.size() - 1);
//        }
//    }

    public static void main(String[] args) {
        int[] A = new int[] {3,4,8,5};
        int size = 10;
        Backpack bk = new Backpack();
        int rst = bk.backpackComplete(size, A);
        List<List<Integer>> rstdetail = new ArrayList<List<Integer>>();
        rstdetail = bk.backPackDetail(size, A);
        System.out.print(rst);
    }
}


