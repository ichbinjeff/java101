import FindandSort.Merge;

/**
 * Created by jli on 4/12/16.
 */
public class MergeTwoSortedArr {
    public int[] merge(int[] a, int[] b) {
        int index = 0;
        int len = a.length + b.length;
        int[] rst = new int[len];
        int leftIndex = 0, rightIndex = 0;

        while (leftIndex < a.length && rightIndex < b.length) {
            if (a[leftIndex] < b[rightIndex]) {
                rst[index ++] = a[leftIndex ++];
            } else {
                rst[index ++] = b[rightIndex ++];
            }
        }

        while (leftIndex < a.length) {
            rst[index ++] = a[leftIndex ++];
        }

        while (rightIndex < b.length) {
            rst[index ++] = b[rightIndex ++];
        }

        return rst;
    }

    public static void main(String[] args) {
        int[] a = new int[] {1,3,5,7,9};
        int[] b = new int[] {2,4,6};

        MergeTwoSortedArr MTS = new MergeTwoSortedArr();
        int[] rst = MTS.merge(a, b);

        System.out.print("done");
    }

}
