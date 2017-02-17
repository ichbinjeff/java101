package DS;

/**
 * Created by jli on 4/19/16.
 */
import java.util.*;
public class nthUglyNumber {
    public int nthUglyNumber (int n) {
//        int[] uglyNum = new int[n];
//        uglyNum[0] = 1;
//        int index = 1;
//        int i2 = 0, i3 = 0, i5 = 0;
//        while (index < n) {
//            int ugly2 = uglyNum[i2] * 2;
//            int ugly3 = uglyNum[i3] * 3;
//            int ugly5 = uglyNum[i5] * 5;
//
//            int min = Math.min(ugly2, Math.min(ugly3, ugly5));
//            if (min == ugly2) i2 ++;
//            if (min == ugly3) i3 ++;
//            if (min == ugly5) i5 ++;
//
//            uglyNum[index ++] = min;
//        }
//
//        return uglyNum[n - 1];

        int i2 = 1, i3 = 1, i5 = 1;
        int[] f = new int[n + 1];
        f[1] = 1;

        int index = 2;
        while (index <= n) {
            int ugly2 = f[i2] * 2;
            int ugly3 = f[i3] * 3;
            int ugly5 = f[i5] * 5;

            int min = Math.min(ugly2, Math.min(ugly3, ugly5));
            if (min == ugly2) {
                i2 ++;
            }
            if (min == ugly3) {
                i3 ++;
            }
            if (min == ugly5) {
                i5 ++;
            }
            f[index++] = min;

        }

        return f[n];
    }

    public static void main(String[] args) {
        nthUglyNumber nun = new nthUglyNumber();
        nun.nthUglyNumber(10);
    }
}
