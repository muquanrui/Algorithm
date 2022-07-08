package ink.vor.notquiteac;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 2022/7/8 15:48
 */
public class LeetCode0958 {
    public boolean isCompleteTree(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur;
        while ((cur = queue.poll()) != null) {
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        while (!queue.isEmpty()) {
            if ((cur = queue.poll()) != null) {
                return false;
            }
        }
        return true;
    }
}
