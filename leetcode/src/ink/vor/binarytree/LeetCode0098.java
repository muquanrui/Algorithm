package ink.vor.binarytree;

/**
 * @author muquanrui
 * @date 25/02/2022 21:47
 */
public class LeetCode0098 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long lowerBound, long upperBound) {
        if (root == null) {
            return true;
        }
        if (root.val <= lowerBound || root.val >= upperBound) {
            return false;
        }
        return isValidBST(root.left, lowerBound, root.val) && isValidBST(root.right, root.val, upperBound);
    }
}
