/**
 * Created by jli on 2/15/16.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        // 1 2 2 3 4 5
        // 1 3
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }

        return count;
    }
}
