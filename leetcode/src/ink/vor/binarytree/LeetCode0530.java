package ink.vor.binarytree;

/**
 * @author muquanrui
 * @date 26/02/2022 20:11
 */
public class LeetCode0530 {
    private int minDiff = Integer.MAX_VALUE;
    private TreeNode pre;

    public int getMinimumDifference(TreeNode root) {
        if (root.left != null) {
            getMinimumDifference(root.left);
        }
        if (pre != null) {
            minDiff = Math.min(minDiff, root.val - pre.val);
        }
        pre = root;
        if (root.right != null) {
            getMinimumDifference(root.right);
        }
        return minDiff;
    }
}
