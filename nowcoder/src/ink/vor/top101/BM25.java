package ink.vor.top101;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 04/04/2022 17:34
 */
public class BM25 {
    private LinkedList<Integer> list;
    // 递归法
    // public int[] postorderTraversal (TreeNode root) {
    //     if (root == null) {
    //         return new int[]{};
    //     }
    //     list = new LinkedList<>();
    //     postorder(root);
    //     int[] arr = new int[list.size()];
    //     for (int i = 0; i < list.size(); i++) {
    //         arr[i] = list.get(i);
    //     }
    //     return arr;
    // }
    // private void postorder(TreeNode root) {
    //     if (root.left != null) {
    //         postorder(root.left);
    //     }
    //     if (root.right != null) {
    //         postorder(root.right);
    //     }
    //     list.addLast(root.val);
    // }

    // 迭代法
    public int[] postorderTraversal (TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        list = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.addLast(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(list.size() - 1 - i);
        }
        return arr;
    }
}
