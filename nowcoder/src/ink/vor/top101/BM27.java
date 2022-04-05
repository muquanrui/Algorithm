package ink.vor.top101;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 05/04/2022 18:00
 */
public class BM27 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        if (pRoot == null) {
            return resList;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        int judge = 0;
        TreeNode cur;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (judge % 2 == 0) {
                    cur = queue.pollLast();
                    if (cur.left != null) {
                        queue.offerFirst(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offerFirst(cur.right);
                    }
                } else {
                    cur = queue.pollFirst();
                    if (cur.right != null) {
                        queue.offerLast(cur.right);
                    }
                    if (cur.left != null) {
                        queue.offerLast(cur.left);
                    }
                }
                list.add(cur.val);
            }
            resList.add(list);
            judge++;
        }
        return resList;
    }
}
