package Array;
import java.util.PriorityQueue;

/**
 * Created by shli15 on 11/23/16.
 */
public class MedianTwoSortedArray {
    // using heap
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
//        for (int i = 0; i < nums1.length; i++) {
//            heap.add(nums1[i]);
//        }
//
//        for (int i = 0; i < nums2.length; i++) {
//            heap.add(nums2[i]);
//        }
//
//        int size = nums1.length + nums2.length;
//        int len = size / 2;
//
//        double median = 0;
//        int last = 0;
//        while (len > 0 && !heap.isEmpty()) {
//            last = heap.poll();
//            len --;
//        }
//        if (size % 2 != 0) {
//            median = heap.poll();
//        } else {
//            median = (double)(last + heap.poll()) / 2;
//        }
//        return median;
//    }

    public double getMedian(int[] nums1, int[] nums2) {
        if (nums1.length == nums2.length) {
            return getMedian(nums1, 0, nums1.length - 1,
                    nums2, 0, nums2.length - 1, nums1.length);
        }
        return -1;
    }

    private double getMedian(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int n) {
        if (n <= 0) {
            return (double)-1;
        }
        if (n == 1) {
            return (double)(nums1[start1] + nums2[start2]) / 2;
        }
        if (n == 2) {
            return (double)(Math.max(nums1[start1], nums2[start2]) + Math.min(nums1[end1], nums2[end2])) / 2;
        }

        int m1 = median(nums1, start1, end1);
        int m2 = median(nums2, start2, end2);

        if (m1 == m2) {
            return m1;
        }

        if (m1 < m2) {
            if (n % 2 == 0) {
                return getMedian(nums1, start1 + n/2 - 1, end1, nums2, start2, end2 - n/2 + 1, n/2 + 1);
            } else {
                return getMedian(nums1, start1 + n/2, end1, nums2, start2, start2 + n/2, n/2 + 1);
            }
        }

        //m2 < m1
        if (n % 2 == 0) {
            return getMedian(nums2, start2 + n/2 - 1, end2, nums1, start1, end1 - n/2 + 1, n/2 + 1);
        }
        return getMedian(nums2, start2 + n/2, end2, nums1, start1, start1 + n/2, n/2 + 1);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if (total % 2 == 0) {
            return (findKth(total/2, nums1, nums2, 0, 0) + findKth(total/2 + 1, nums1, nums2, 0, 0)) / 2.0;
        }
        return findKth(total/2 + 1, nums1, nums2, 0, 0);
    }

    public int findKth(int k , int[] nums1, int[] nums2, int s1, int s2) {
        if (s1 >= nums1.length) {
            return nums2[s2 + k - 1];
        }

        if (s2 >= nums2.length) {
            return nums1[s1 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }

        int m1 = s1 + k/2 - 1;
        int m2 = s2 + k/2 - 1;
        int median1 = m1 < nums1.length ? nums1[m1] : Integer.MAX_VALUE;
        int median2 = m2 < nums2.length ? nums2[m2] : Integer.MAX_VALUE;
        if (median1 < median2) {
            return findKth(k - k/2, nums1, nums2, m1 + 1, s2);
        } else {
            return findKth(k - k/2, nums1, nums2, s1, m2 + 1);
        }
    }
    //1234567
    // 0 2
    private int median(int[] arr, int start, int end) {
        int n = end - start + 1;
        if (n % 2 == 0) {
            return (arr[start + n/2] + arr[start + n/2 - 1]) / 2;
        }
        return arr[start + n/2];
    }
//    15 26 8
//    2 13 7
    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 12, 15, 26};
        int[] nums2 = new int[] {2, 13, 17, 30};
        MedianTwoSortedArray MTS = new MedianTwoSortedArray();
        double rst = MTS.findMedianSortedArrays(nums1, nums2);
        double rst2 = MTS.getMedian(nums1, nums2);
        System.out.print(rst2);
    }
}
