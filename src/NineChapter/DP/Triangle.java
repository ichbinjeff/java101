package NineChapter.DP;

/**
 * Created by shli15 on 6/20/16.
 *
*/
//1
//23
//456
//TODO
public class Triangle {
    int min = Integer.MAX_VALUE;
    int [][] hash;
    public int minimumTotalSearch(int[][] triangle) {
        hash = new int[triangle.length][triangle[0].length];
        min = searchDC(triangle, 0, 0, 0);
        return min;
    }
    // dfs 把所有路径都走一遍 traverse
    public void search(int[][] triangle, int x, int y, int sum) {
        printCoord(x, y);
        if (x == triangle.length) {
            min = Math.min(min, sum);
            return;
        }

        search(triangle, x + 1, y, sum + triangle[x][y]);
        search(triangle, x + 1, y + 1, sum + triangle[x][y]);
    }

    // divide and conquer  记忆化搜索
    public int searchDC(int[][] triangle, int x, int y, int sum) {
        printCoord(x, y);
        if (x == triangle.length) {
            return sum;
        }

        if (hash[x][y] != 0) {
            sum = hash[x][y] + triangle[x][y];
        } else {
            sum = Math.min(searchDC(triangle, x + 1, y, sum), searchDC(triangle, x + 1, y + 1, sum)) + triangle[x][y];
            hash[x][y] = sum;
        }
        return sum;
    }


    public static void main(String[] args) {
        int[][] triangle = new int[4][4];
        triangle[0][0] = 2;
        triangle[1][0] = 3;
        triangle[1][1] = 4;
        triangle[2][0] = 6;
        triangle[2][1] = 5;
        triangle[2][2] = 7;
        triangle[3][0] = 4;
        triangle[3][1] = 1;
        triangle[3][2] = 8;
        triangle[3][3] = 3;

        Triangle tri = new Triangle();
        System.out.print(tri.minimumTotalSearch(triangle));
    }

    public int minimumTotal(int[][] triangle) {
        return 1;
    }

    private void printCoord(int x, int y) {
        System.out.print("x:" + x);
        System.out.print(" y:" + y);
        System.out.print("\n");
    }


}
