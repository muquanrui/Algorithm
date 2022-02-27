package ink.vor.binarytree;

/**
 * @author muquanrui
 * @date 27/02/2022 23:37
 */
public class LeetCode0701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
