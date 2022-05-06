package ink.vor.banarytree;

/**
 * @author muquanrui
 * @date 2022/5/6 11:40
 */
public class LeetCode0701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
