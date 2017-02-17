package BinaryTree;

import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by jli on 2/15/16.
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList rst = new ArrayList();
        if (root == null) {
            return rst;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);

        while (!q.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                list.add(curr.val);
                if (curr.left != null) {
                    q.offer(curr.left);
                }

                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            rst.add(new ArrayList(list));
        }
        return rst;

    }
}
