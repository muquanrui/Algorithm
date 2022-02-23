package ink.vor.binarytree;

/**
 * @author muquanrui
 * @date 23/02/2022 20:35
 */
public class LeetCode0112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasPathSum(root, targetSum, 0);
    }

    private boolean hasPathSum(TreeNode root, int targetSum, int sum) {
        if (root.left == null && root.right == null) {
            return sum + root.val == targetSum;
        }
        boolean leftRes = false;
        if (root.left != null) {
            leftRes = hasPathSum(root.left, targetSum, sum + root.val);
        }
        if (!leftRes && root.right != null) {
            return hasPathSum(root.right, targetSum, sum + root.val);
        }
        return leftRes;
    }
}
