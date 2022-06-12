package ink.vor.notquiteac;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/6/12 14:56
 */
public class LeetCode0111 {
/*    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }*/
public int minDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    Deque<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int minDepth = 0;
    while (!queue.isEmpty()) {
        int size = queue.size();
        minDepth++;
        for (int i = 0; i < size; i++) {
            TreeNode cur = queue.poll();
            if (cur.left == null && cur.right == null) {
                return minDepth;
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }
    return minDepth;
}
}