/**
 * Created by shli15 on 11/27/16.
 */
import java.util.Stack;
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int number = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(i, j, grid, visited);
                    number ++;
                }
            }
        }
        return number;
    }

    public void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        if (visited[i][j]) return;
        visited[i][j] = true;
        // up
        if (i - 1 >= 0 && grid[i-1][j] == '1') {
            dfs(i - 1, j, grid, visited);
        }
        // down
        if (i + 1 < grid.length && grid[i+1][j] == '1') {
            dfs(i + 1, j, grid, visited);
        }
        // left
        if (j - 1 >= 0 && grid[i][j-1] == '1') {
            dfs(i, j - 1, grid, visited);
        }
        // right
        if (j + 1 < grid[0].length && grid[i][j+1] == '1') {
            dfs(i, j + 1, grid, visited);
        }
    }

    private void dfsNonRec(int l, int r, char[][] grid, boolean[][] visited) {
        Stack<Coordinator> stack = new Stack<Coordinator>();
        stack.push(new Coordinator(l, r));
        while (!stack.isEmpty()) {
            Coordinator c = stack.peek();
            int i = c.i, j = c.j;
            if (visited[i][j]) {
                stack.pop();
            } else {
                visited[i][j] = true;
                // up
                if (i - 1 >= 0 && grid[i-1][j] == '1') {
                    stack.push(new Coordinator(i - 1, j));
                }
                // down
                if (i + 1 < grid.length && grid[i+1][j] == '1') {
                    stack.push(new Coordinator(i + 1, j));
                }
                // left
                if (j - 1 >= 0 && grid[i][j-1] == '1') {
                    stack.push(new Coordinator(i, j - 1));
                }
                // right
                if (j + 1 < grid[0].length && grid[i][j+1] == '1') {
                    stack.push(new Coordinator(i, j + 1));
                }
            }
        }
    }

    private class Coordinator{
        int i, j;
        Coordinator(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        char[][] islands = new char[][] {{'1','0','1','1','1'}, {'1','0','1','0','1'},{'1','1','1','0','1'}};
        NumberOfIslands NI = new NumberOfIslands();
        int number = NI.numIslands(islands);
        System.out.print(number);
    }
}
