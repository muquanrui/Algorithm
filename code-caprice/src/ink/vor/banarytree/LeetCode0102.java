package ink.vor.banarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/5/3 17:25
 */
public class LeetCode0102 {
    List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    continue;
                }
                tmpList.add(cur.val);
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
            if (tmpList.size() > 0) {
                resList.add(tmpList);
            }
        }
        return resList;
    }
}
