package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/6/28 13:15
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
            TreeNode tmp = root.left.right;
            root.left.right = root.right;
            root = root.left;
            TreeNode cur = root.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            cur.left = tmp;
        }
        return root;
    }
}
