package DP;
import java.util.ArrayList;
/**
 * Created by jli on 12/16/15.
 */
public class Subset {
    ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
    public void subset(ArrayList<ArrayList<Integer>> rst, ArrayList<Integer> level, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (level.contains(nums[i])) {
                level.add(nums[i]);
            }




        }
    }

}
