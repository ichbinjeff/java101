/**
 * Created by jli on 10/26/15.
 */
public class SearchInBigSortedArr {
    public static int search(int[] A, int target) {
        int end = 0;
        while (end < A.length && A[end] < target) {
            end = end * 2 + 1;
        }

        int start = 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (A[start] == target) {
            return start;
        }

        if (A[end] == target) {
            return end;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] A = new int[] {1,3,6,9,21};
        int target = 4;
        System.out.print(SearchInBigSortedArr.search(A, target));
    }
}
