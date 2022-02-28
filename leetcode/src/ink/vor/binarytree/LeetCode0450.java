package ink.vor.binarytree;

/**
 * @author muquanrui
 * @date 28/02/2022 21:49
 */
public class LeetCode0450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode pre = root;
                TreeNode maxLeft = root.left;
                while (maxLeft.right != null) {
                    pre = maxLeft;
                    maxLeft = maxLeft.right;
                }
                if (pre != root) {
                    pre.right = null;
                } else {
                    pre.left = null;
                }
                maxLeft.right = root.right;
                TreeNode minOfMaxLeft = maxLeft;
                while (minOfMaxLeft.left != null) {
                    minOfMaxLeft = minOfMaxLeft.left;
                }
                minOfMaxLeft.left = root.left;
                return maxLeft;
            }
        }
        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);
        return root;
    }
}
