package ink.vor.top101;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 06/04/2022 03:42
 */
public class BM35 {
    public boolean isCompleteTree (TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur;
        while ((cur = queue.poll()) != null) {
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            if (queue.poll() != null) {
                return false;
            }
        }
        return true;
    }
}
