package ink.vor.sword2offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/4/23 17:50
 */
public class Offer32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new LinkedList<>();
        if (root == null) {
            return resList;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            resList.add(list);
        }
        return resList;
    }
}
