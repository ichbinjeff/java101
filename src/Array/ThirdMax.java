package Array;

/**
 * Created by shli15 on 12/1/16.
 */
public class ThirdMax {
    public int thirdMax(int[] nums) {
        long first = Integer.MIN_VALUE - 1,
                second = Integer.MIN_VALUE - 1,
                third = Integer.MIN_VALUE - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
            } else if (nums[i] > second && nums[i] < first) {
                third = second;
                second = nums[i];
            } else if (nums[i] > third && nums[i] < second) {
                third = nums[i];
            }
        }
        if (third != Integer.MIN_VALUE - 1) {
            return (int)third;
        } else {
            return (int)first;
        }
    }

    private int quickSelect(int[] nums, int pos, int start, int end) {
        if (start >= end) return nums[start];
        int pls = partition(nums, start, end);
        if (pls == pos) {
            return nums[pls];
        } else if (pls < pos) {
            return quickSelect(nums, pos, pls + 1, end);
        } else {
            return quickSelect(nums, pos, start, pls - 1);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        while (start < end) {
            while (start < end && nums[end] < pivot) {
                end --;
            }
            if (start < end) {
                nums[start ++] = nums[end];
            }
            while (start < end && nums[start] > pivot) {
                start ++;
            }
            if (start < end) {
                nums[end --] = nums[start];
            }
        }
        nums[start] = pivot;
        return start;
    }



    public static void main(String[] args) {
        ThirdMax TM = new ThirdMax();
        int[] tst = new int[] {2,2,3,1};
        int rst = TM.thirdMax(tst);
        System.out.print(rst);
    }
}
