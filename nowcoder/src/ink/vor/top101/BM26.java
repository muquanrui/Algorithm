package ink.vor.top101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 04/04/2022 21:01
 */
public class BM26 {
    private ArrayList<ArrayList<Integer>> resList;
    // 递归法
//     public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
//         resList = new ArrayList<>();
//         levelorder(root, 0);
//         return resList;
//     }
//     private void levelorder(TreeNode root, int level) {
//         if (resList.size() == level) {
//             resList.add(new ArrayList<Integer>(Arrays.asList(root.val)));
//         } else {
//             resList.get(level).add(root.val);
//         }
//         if (root.left != null) {
//             levelorder(root.left, level + 1);
//         }
//         if (root.right != null) {
//             levelorder(root.right, level + 1);
//         }
//     }

    // 迭代法
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        resList = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            resList.add(list);
        }
        return resList;
    }
}
