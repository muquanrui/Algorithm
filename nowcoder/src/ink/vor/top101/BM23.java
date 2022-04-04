package ink.vor.top101;

import com.sun.source.tree.Tree;

import java.util.*;

/**
 * @author muquanrui
 * @date 04/04/2022 16:58
 */
public class BM23 {
    private LinkedList<Integer> list;
    // 递归法
    // public int[] preorderTraversal (TreeNode root) {
    //     if (root == null) {
    //         return new int[]{};
    //     }
    //     list = new LinkedList<>();
    //     preorder(root);
    //     int[] arr = new int[list.size()];
    //     for (int i = 0; i < list.size(); i++) {
    //         arr[i] = list.get(i);
    //     }
    //     return arr;
    // }
    // private void preorder(TreeNode root) {
    //     list.addLast(root.val);
    //     if (root.left != null) {
    //         preorder(root.left);
    //     }
    //     if (root.right != null) {
    //         preorder(root.right);
    //     }
    // }

    // 迭代法
    public int[] preorderTraversal (TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        list = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            list.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
