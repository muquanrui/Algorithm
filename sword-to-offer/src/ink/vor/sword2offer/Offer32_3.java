package ink.vor.sword2offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/4/23 17:51
 */
public class Offer32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new LinkedList<>();
        if (root == null) {
            return resList;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp;
                if (flag) {
                    temp = queue.removeLast();
                    if (temp.left != null) {
                        queue.addFirst(temp.left);
                    }
                    if (temp.right != null) {
                        queue.addFirst(temp.right);
                    }
                } else {
                    temp = queue.removeFirst();
                    if (temp.right != null) {
                        queue.addLast(temp.right);
                    }
                    if (temp.left != null) {
                        queue.addLast(temp.left);
                    }
                }
                list.add(temp.val);
            }
            flag = !flag;
            resList.add(list);
        }
        return resList;
    }
}
