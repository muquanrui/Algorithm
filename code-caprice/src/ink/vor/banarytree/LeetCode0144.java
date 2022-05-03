package ink.vor.banarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/5/3 16:27
 */
public class LeetCode0144 {
    List<Integer> resList = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur == null) {
                continue;
            }
            resList.add(cur.val);
            stack.push(cur.right);
            stack.push(cur.left);
        }
        return resList;
    }
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     preorder(root);
    //     return resList;
    // }

    // private void preorder(TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }
    //     resList.add(root.val);
    //     preorder(root.left);
    //     preorder(root.right);
    // }
}
