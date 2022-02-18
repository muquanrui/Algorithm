package ink.vor.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 18/02/2022 22:43
 */
public class LeetCode0145 {
    List<Integer> resList;

    public List<Integer> postorderTraversal(TreeNode root) {
        resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        recursiveTraversal(root);
        return resList;
    }

    private void recursiveTraversal(TreeNode node) {
        if (node.left != null) {
            recursiveTraversal(node.left);
        }
        if (node.right != null) {
            recursiveTraversal(node.right);
        }
        resList.add(node.val);
    }
}
