package Search;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by shli15 on 12/10/16.
 */
public class WaterFlow {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> rst = new ArrayList<int[]>();
        if (matrix == null || matrix.length == 0) {
            return rst;
        }
        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            dfs(matrix, Integer.MIN_VALUE, i, 0, atlantic);
            dfs(matrix, Integer.MIN_VALUE, i, matrix[0].length-1, pacific);
        }
        for (int j = 0; j < matrix[0].length; j++) {
            dfs(matrix, Integer.MIN_VALUE, 0, j, atlantic);
            dfs(matrix, Integer.MIN_VALUE, matrix.length - 1, j, pacific);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    rst.add(new int[]{i, j});
                }
            }
        }
        return rst;
    }

    private void dfs(int[][] matrix, int pre, int i, int j, boolean[][] canreach) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || canreach[i][j] || pre > matrix[i][j]) {
            return;
        }
        canreach[i][j] = true;
        dfs(matrix, matrix[i][j], i-1, j, canreach);
        dfs(matrix, matrix[i][j], i+1, j, canreach);
        dfs(matrix, matrix[i][j], i, j-1, canreach);
        dfs(matrix, matrix[i][j], i, j+1, canreach);
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}
        };
        WaterFlow WF = new WaterFlow();
        WF.pacificAtlantic(matrix);
        System.out.print("done");
    }
}
