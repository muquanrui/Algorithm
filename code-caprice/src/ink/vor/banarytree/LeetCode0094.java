package ink.vor.banarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/5/3 16:27
 */
public class LeetCode0094 {
    List<Integer> resList = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                resList.add(cur.val);
                cur = cur.right;
            }
        }
        return resList;
    }

    // public List<Integer> inorderTraversal(TreeNode root) {
    //     inorder(root);
    //     return resList;
    // }

    // private void inorder(TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }
    //     inorder(root.left);
    //     resList.add(root.val);
    //     inorder(root.right);
    // }
}
