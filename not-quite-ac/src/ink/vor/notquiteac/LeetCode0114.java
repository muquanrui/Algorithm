package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/6/12 15:19
 */
public class LeetCode0114 {
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (pre != null) {
            pre.right = root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        pre = root;
        flatten(left);
        flatten(right);
    }
}
