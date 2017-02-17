package FindandSort;

import java.util.ArrayList;

/**
 * Created by jli on 12/16/15.
 */
public class Merge {
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int i = 0, j = 0;
        while (i <= m && j <= n) {

        }
    }

    public int[] traditionalMerge(int[] A, int m, int[] B, int n) {
        int i = 0, j = 0;
        int[] rst = new int[m + n - 1];
        int k = 0;

        while (i <= m && j <= n) {
            if (A[i] <= B[j]) {
                rst[k++] = A[i++];
            } else {
                rst[k++] = B[j++];
            }
        }

        while (i <= m) {
            rst[k++] = A[i++];
        }

        while (j <= n) {
            rst[k++] = B[j++];
        }

        return rst;
    }


    public static void merge(int[] a, int b[], int lastA, int lastB) {
        int indexA = lastA - 1;
        int indexB = lastB - 1;
        int indexMerged = lastB + lastA - 1;

        while (indexA >= 0 && indexB >= 0) {
            if (a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA];
                indexMerged --;
                indexA --;
            } else {
                a[indexMerged] = b[indexB];
                indexMerged --;
                indexB --;
            }
        }

        while (indexB >= 0) {
            a[indexMerged] = b[indexB];
            indexMerged --;
            indexB --;
        }
    }

    public static void main(String[] args) {
        int [] a = new int[10];
        int [] b = new int[3];

        a[0] = 20;
        a[1] = 17;
        a[2] = 14;
        b[0] = 19;
        b[1] = 16;
        b[2] = 12;

        Merge m = new Merge();
        m.merge(a, b, 3, 3);

        System.out.print("done");
    }
}
