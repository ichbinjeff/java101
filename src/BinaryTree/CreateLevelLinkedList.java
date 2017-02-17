package BinaryTree;

import apple.laf.JRSUIUtils;
import sun.awt.image.ImageWatched;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by jli on 11/4/15.
 */
public class CreateLevelLinkedList {
    public ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        createLevelLinkedList(root, lists, 0);
        return lists;
    }

    public void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null) return;

        LinkedList<TreeNode> list = null;
        if (lists.size() == level) {
            list = new LinkedList<TreeNode>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }

        list.add(root);
        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right, lists, level + 1);
    }

    public ArrayList<LinkedList<TreeNode>> createLevelLinkedListBST(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();

        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        if (root != null) {
            current.add(root);
        }

        while(current.size() > 0) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();
            for (TreeNode parent: parents) {
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }

        return result;
    }
}
