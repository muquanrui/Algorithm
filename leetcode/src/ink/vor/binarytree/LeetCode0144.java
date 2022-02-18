package ink.vor.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 18/02/2022 22:36
 */
public class LeetCode0144 {
    List<Integer> resList;
    public List<Integer> preorderTraversal(TreeNode root) {
        resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        recursiveTraversal(root);
        return resList;
    }

    private void recursiveTraversal(TreeNode node) {
        resList.add(node.val);
        if (node.left != null) {
            recursiveTraversal(node.left);
        }
        if (node.right != null) {
            recursiveTraversal(node.right);
        }
    }
}
