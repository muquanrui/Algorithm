package ink.vor.binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author muquanrui
 * @date 18/02/2022 22:43
 */
public class LeetCode0145 {
    // List<Integer> resList;
    //
    // public List<Integer> postorderTraversal(TreeNode root) {
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
    //     if (node.right != null) {
    //         recursiveTraversal(node.right);
    //     }
    //     resList.add(node.val);
    // }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            resList.add(temp.val);
            if (temp.left != null) {
                stack.push(temp.left);
            }
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }
        Collections.reverse(resList);
        return resList;
    }
}
