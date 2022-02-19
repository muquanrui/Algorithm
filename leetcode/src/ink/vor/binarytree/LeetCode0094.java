package ink.vor.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author muquanrui
 * @date 18/02/2022 22:45
 */
public class LeetCode0094 {
    // List<Integer> resList;
    //
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     resList = new ArrayList<>();
    //     if (root == null) {
    //         return resList;
    //     }
    //     recursiveTraversal(root);
    //     return resList;
    // }
    //
    // private void recursiveTraversal(TreeNode node) {
    //     if (node.left != null) {
    //         recursiveTraversal(node.left);
    //     }
    //     resList.add(node.val);
    //     if (node.right != null) {
    //         recursiveTraversal(node.right);
    //     }
    // }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
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
}