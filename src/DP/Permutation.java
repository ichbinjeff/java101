package DP;

import java.util.ArrayList;

/**
 * Created by jli on 12/16/15.
 */
public class Permutation {
    ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
    public void permutation(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> level, int[] nums) {
        if (level.size() == nums.length) {
            rst.add(level);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (level.contains(nums[i])) {
                level.add(nums[i]);
            }
            permutation(rst, level, nums);
            level.remove(level.size() - 1);
        }
    }
}
