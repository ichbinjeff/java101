/**
 * Created by jli on 4/17/16.
 */
public class Maxdiff {
    public static int maxDifference(int[] a) {
        int min = 0;
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            int curr = a[i];
            maxDiff = Math.max(a[i] - min, maxDiff);
            min = Math.min(curr, min);
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        int[] test = new int[] {2,3, 10, 2, 4, 8, 1};
        Maxdiff md = new Maxdiff();
        md.maxDifference(test);
        System.out.print("done");

    }

}
