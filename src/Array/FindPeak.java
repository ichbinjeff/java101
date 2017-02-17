package Array;

/**
 * Created by jli on 3/11/16.
 */
public class FindPeak {
        public int find(int[] A) {
            int start = 0, end = A.length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (A[mid - 1] < A[mid] && A[mid + 1] > A[mid]) {
                    start = mid;
                } else if (A[mid - 1] < A[mid] && A[mid + 1] < A[mid]) {
                    return mid;
                } else if (A[mid - 1] > A[mid] && A[mid + 1] < A[mid]) {
                    end = mid;
                }
            }

            if (A[start] < A[end]) {
                return end;
            }

            return start;
        }

        public static void main(String[] args) {
            FindPeak fp = new FindPeak();
            int[] A = new int[] {100,102,104,7,9,11,4,3};
            int num = fp.find(A);
            System.out.print("fjdsfsdf");
        }
    }

