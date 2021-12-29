package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 29/12/2021 16:18
 */
public class LeetCode0226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right != null) {
            root.left = root.right;
            root.right = null;
            invertTree(root.left);
        } else if (root.left != null && root.right == null) {
            root.right = root.left;
            root.left = null;
            invertTree(root.right);
        } else if (root.left != null && root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
