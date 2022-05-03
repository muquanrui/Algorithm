package ink.vor.banarytree;

/**
 * @author muquanrui
 * @date 2022/5/3 19:18
 */
public class LeetCode0110 {
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLength = getDepth(root.left);
        if (leftLength == -1) {
            return -1;
        }
        int rightLength = getDepth(root.right);
        if (rightLength == -1) {
            return -1;
        }
        return Math.abs(leftLength - rightLength) > 1 ? -1 : Math.max(leftLength, rightLength) + 1;
    }
}
