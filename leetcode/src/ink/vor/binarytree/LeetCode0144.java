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
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return result;
    }
}
