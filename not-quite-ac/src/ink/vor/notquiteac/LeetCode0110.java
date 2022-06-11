package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/6/11 21:01
 */
public class LeetCode0110 {
    public boolean isBalanced(TreeNode root) {
        int depth = getDepth(root);
        return depth != Integer.MAX_VALUE;
    }
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == Integer.MAX_VALUE || rightDepth == Integer.MAX_VALUE || Math.abs(leftDepth - rightDepth) > 1) {
            return Integer.MAX_VALUE;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
