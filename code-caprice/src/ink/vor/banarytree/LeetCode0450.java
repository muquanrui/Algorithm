package ink.vor.banarytree;

/**
 * @author muquanrui
 * @date 2022/5/6 11:40
 */
public class LeetCode0450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode newRight = root.left;
            while (newRight.right != null) {
                newRight = newRight.right;
            }
            newRight.right = root.right;
            root = root.left;
        }
        return root;
    }
}
