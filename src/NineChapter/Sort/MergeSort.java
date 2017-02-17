package NineChapter.Sort;

import FindandSort.Merge;

/**
 * Created by shli15 on 7/1/16.
 */
public class MergeSort {
    public void mergeSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        mergeSort(nums, 0, nums.length - 1);
    }

    public void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        // 第一个为mid第二个为mid + 1, 否则会死循 反例(0, 2) start 0, end 2, mid 1
        // mg(0,2) -> mg(0,1)  mg(1,2) - mg(1,0) mg(1,2) - mg(1,0), mg(1,2) 死循环了
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        int[] temp = new int[end - start + 1];
        merge(nums, start, mid, end, temp);

        for (int i = 0; i < temp.length; i++) {
            nums[start + i] = temp[i];
        }
    }

    public void merge(int[] nums, int start, int mid, int end, int[] temp) {
        int i = start, j = mid + 1;
        int a1 = mid;
        int a2 = end;

        int index = 0;
        while (i <= a1 && j <= a2) {
            if (nums[i] < nums[j]) {
                temp[index ++] = nums[i ++];
            } else {
                temp[index ++] = nums[j ++];
            }
        }

        while (i <= a1) {
            temp[index ++] = nums[i ++];
        }

        while (j <= a2) {
            temp[index ++] = nums[j ++];
        }

    }

    public static void main(String[] args) {
        int[] test = new int[] {3,5,1,2,4};
        MergeSort Ms = new MergeSort();
        Ms.mergeSort(test);
//        int[] temp = new int[2];
//        Ms.merge(test, 0, 1, 1, temp);
        System.out.print("done");

    }
}
