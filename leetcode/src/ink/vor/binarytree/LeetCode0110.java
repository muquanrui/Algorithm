package ink.vor.binarytree;

/**
 * @author muquanrui
 * @date 22/02/2022 20:18
 */
public class LeetCode0110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (getDepth(root) == -1) {
            return false;
        } else {
            return true;
        }
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = getDepth(node.left);
        if (leftDepth == -1 ) {
            return -1;
        }
        int rightDepth = getDepth(node.right);
        if (rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        } else {
            return 1 + Math.max(leftDepth, rightDepth);
        }
    }
}
