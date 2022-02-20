package ink.vor.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author muquanrui
 * @date 18/02/2022 22:36
 */
public class LeetCode0144 {
    // List<Integer> resList;
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     resList = new ArrayList<>();
    //     if (root == null) {
    //         return resList;
    //     }
    //     recursiveTraversal(root);
    //     return resList;
    // }
    //
    // private void recursiveTraversal(TreeNode node) {
    //     resList.add(node.val);
    //     if (node.left != null) {
    //         recursiveTraversal(node.left);
    //     }
    //     if (node.right != null) {
    //         recursiveTraversal(node.right);
    //     }
    // }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            resList.add(temp.val);
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
        }
        return resList;
    }
}
