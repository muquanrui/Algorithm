package ink.vor.banarytree;

/**
 * @author muquanrui
 * @date 2022/5/6 11:39
 */
public class LeetCode0530 {
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }
    TreeNode pre = null;
    private void inorder(TreeNode root) {
        if (root.left != null) {
            inorder(root.left);
        }
        if (pre != null) {
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;
        if (root.right != null) {
            inorder(root.right);
        }
    }
}
