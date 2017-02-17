package Search;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Created by shli15 on 10/30/16.
 */
public class NumberOfIslands {
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0) {
            return 0;
        }

        List<List<String>> rst = new ArrayList<List<String>>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    bfs(rst, visited, grid, i, j);
                }
            }
        }

        return rst.size();

    }

    private void bfs(List<List<String>> rst, boolean[][] visited, boolean[][] grid, int i, int j) {
        List<String> level = new ArrayList<String>();
        Queue<Coordinator> queue = new LinkedList<Coordinator>();
        queue.offer(new Coordinator(i, j));


        while (!queue.isEmpty()) {
            Coordinator curr = queue.poll();
            if (!visited[curr.x][curr.y]) {
                addAdj(queue, grid, curr);
                visited[curr.x][curr.y] = true;
                level.add(String.valueOf(curr.x) + String.valueOf(curr.y));
            }
        }

        if (level.size() > 0) {
            rst.add(level);
        }
    }

    private void addAdj(Queue<Coordinator> queue, boolean[][] grid, Coordinator curr) {
        int i = curr.x, j = curr.y;
        // up i - 1, j
        if (i - 1 >= 0 && grid[i - 1][j]) {
            queue.add(new Coordinator(i - 1, j));
        }

        // down i + 1, j
        if (i + 1 < grid.length && grid[i + 1][j]) {
            queue.add(new Coordinator(i + 1, j));
        }

        // left i, j - 1
        if (j - 1 >= 0 && grid[i][j - 1]) {
            queue.add(new Coordinator(i, j - 1));
        }

        // right i, j + 1
        if (j + 1 < grid[0].length && grid[i][j + 1]) {
            queue.add(new Coordinator(i, j + 1));
        }
    }

    class Coordinator {
        int x, y;
        public Coordinator(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
//        boolean[][] tst = new boolean[][] {
//                {true, true, false, false, false},
//                {false, true, false, false, true},
//                {false, false, false, true, true},
//                {false, false,false,false,false},
//                {false,false,false,false,true}
//        };
        boolean[][] tst = new boolean[][] {{true, true}};
        NumberOfIslands NIL = new NumberOfIslands();
        NIL.numIslands(tst);

    }
}
