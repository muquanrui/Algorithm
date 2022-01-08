package ink.vor.top100liked;

import java.util.Map;

/**
 * @author muquanrui
 * @date 08/01/2022 13:28
 */
public class LeetCode0543 {
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        recursiveHeight(root);
        return diameter;
    }

    public int diameter;
    public int recursiveHeight(TreeNode node) {
        int leftHeight = 0;
        int rightHeight = 0;
        if (node.left != null) {
            leftHeight = recursiveHeight(node.left) + 1;
        }
        if (node.right != null) {
            rightHeight = recursiveHeight(node.right) + 1;
        }

        diameter = Math.max(leftHeight + rightHeight, diameter);
        return Math.max(leftHeight, rightHeight);
    }
}
