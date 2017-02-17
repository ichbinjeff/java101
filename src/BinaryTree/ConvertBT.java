package BinaryTree;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by shli15 on 8/2/16.
 */
public class ConvertBT {
    public List<Integer> convert(TreeNode root) {
        List<Integer> rst = new ArrayList<Integer>();
        addLeft(rst, root);
        addLeftRight(rst, root);
        addRightLeft(rst, root);
        addRight(rst, root);
        return rst;
    }

    public void addLeft(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        addLeft(list, root.left);
        if (!list.contains(root)) {
            list.add(root.val);
        }
    }

    public void addLeftRight(List<Integer> list, TreeNode root) {
        if (root.right == null) {
            return;
        }

        addLeftRight(list, root.left);
        if (!list.contains(root)) {
            list.add(root.right.val);
        }
    }

    public void addRightLeft(List<Integer> list, TreeNode root) {
        if (root.left == null) {
            return;
        }

        addRightLeft(list, root.right);
        if (!list.contains(root)) {
            list.add(root.left.val);
        }
    }


    public void addRight(List<Integer> list, TreeNode root) {
        if (root.right == null) {
            return;
        }
        if (!list.contains(root)) {
            list.add(root.right.val);
        }
        addRight(list, root.right);
    }

}
