package Array;

/**
 * Created by shli15 on 11/24/16.
 */
public class Zigzagconcat {
    String printZigZagConcat(String str, int n) {
        StringBuilder sb = new StringBuilder();
        if (n == 1) {
            return str;
        }

        int len = str.length();
        int row = 0;
        char[] strArry = str.toCharArray();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = "";
        }
        boolean down = false;
        for (int i = 0; i < len; i++) {
            arr[row] += strArry[i];
            if (row == n - 1) {
                down = false;
            } else if (row == 0) {
                down = true;
            }

            if (down) row++;
                else row --;
        }

        for (int i = 0; i < n; i++) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "GEEKSFORGEEKS";
        int n = 3;
        Zigzagconcat zigzag = new Zigzagconcat();
        String rst = zigzag.printZigZagConcat(str, n);
        System.out.print(rst);
    }
}
