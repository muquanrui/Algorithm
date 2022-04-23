package ink.vor.sword2offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/4/23 17:53
 */
public class Offer37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp == null) {
                    sb.append('*');
                    sb.append('|');
                    continue;
                }
                sb.append(temp.val);
                sb.append('|');
                queue.offer(temp.left);
                queue.offer(temp.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 2) {
            return null;
        }
        String[] nodes = data.split("\\|");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            String left = nodes[index++];
            String right = nodes[index++];
            if (left.equals("*")) {
                temp.left = null;
            } else {
                temp.left = new TreeNode(Integer.parseInt(left));
                queue.offer(temp.left);
            }
            if (right.equals("*")) {
                temp.right = null;
            } else {
                temp.right = new TreeNode(Integer.parseInt(right));
                queue.offer(temp.right);
            }
        }
        return root;
    }
}
