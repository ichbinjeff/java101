package BinaryTree;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by shli15 on 10/9/16.
 */
public class SerializationBinaryTree {
    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            return "{}";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);

        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null) {
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }

        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }

        sb.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null) {
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(node.val);
            }
        }

        sb.append("}");
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data == null || data.length() == 0) {
            return null;
        }
        int index = 0;
        boolean left = true;
        String[] item = data.substring(1, data.length() - 1).split(",");

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(item[0]));
        queue.add(root);

        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.get(queue.size() - 1));
        }

        for (int i = 1; i < item.length; i++) {
            if (!item[i].equals("#")) {
                TreeNode subNode = new TreeNode(Integer.parseInt(item[i]));
                queue.add(subNode);
                if (left) {
                    queue.get(index).left = subNode;
                } else {
                    queue.get(index).right = subNode;
                }
            }

            if (!left) {
                index ++;
            }

            left = !left;
        }

        return root;
    }

    public static void main(String[] args) {
        SerializationBinaryTree SBT = new SerializationBinaryTree();
        TreeNode root = SBT.deserialize("{1,#,2}");
        System.out.print("system");
    }
}
