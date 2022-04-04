package ink.vor.top101;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author muquanrui
 * @date 04/04/2022 17:27
 */
public class BM24 {
    private LinkedList<Integer> list;
    // 递归法
    // public int[] inorderTraversal (TreeNode root) {
    //     if (root == null) {
    //         return new int[]{};
    //     }
    //     list = new LinkedList<>();
    //     inorder(root);
    //     int[] arr = new int[list.size()];
    //     for (int i = 0; i < list.size(); i++) {
    //         arr[i] = list.get(i);
    //     }
    //     return arr;
    // }
    // private void inorder(TreeNode root) {
    //     if (root.left != null) {
    //         inorder(root.left);
    //     }
    //     list.addLast(root.val);
    //     if (root.right != null) {
    //         inorder(root.right);
    //     }
    // }

    // 迭代法
    public int[] inorderTraversal (TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        list = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur.left != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                list.addLast(cur.val);
                while (cur.right == null && !stack.isEmpty()) {
                    cur = stack.pop();
                    list.addLast(cur.val);
                }
                cur = cur.right;
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
