package ink.vor.banarytree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/5/3 17:22
 */
public class LeetCode0145 {
    LinkedList<Integer> resList = new LinkedList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur == null) {
                continue;
            }
            resList.addFirst(cur.val);
            stack.push(cur.left);
            stack.push(cur.right);
        }
        return resList;
    }

    // public List<Integer> postorderTraversal(TreeNode root) {
    //     postorder(root);
    //     return resList;
    // }

    // private void postorder(TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }
    //     postorder(root.left);
    //     postorder(root.right);
    //     resList.add(root.val);
    // }
}
