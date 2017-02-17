package BinaryTree;

/**
 * Created by jli on 11/4/15.
 */
public class CreateMinimalBST {
    public TreeNode createMinimalBST(int[] arr) {
       return createMinimalBST(arr, 0, arr.length - 1);
    }

    public TreeNode createMinimalBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = createMinimalBST(arr, start, mid - 1);
        n.right = createMinimalBST(arr, mid + 1, end);

        return n;
    }

    public TreeNode createBinaryTree(int[] nums) {
        int len = nums.length;
        int mid = len / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if (mid == 0) {
            return root;
        }

//        root.left = createBinaryTree(nums.slice(0, mid - 1));
//        root.right = createBinaryTree(nums.slice(mid + 1, len));
        return root;
    }
}
