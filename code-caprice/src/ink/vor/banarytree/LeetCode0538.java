package ink.vor.banarytree;

/**
 * @author muquanrui
 * @date 2022/5/6 11:40
 */
public class LeetCode0538 {
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        reverseTraversal(root);
        return root;
    }

    TreeNode next = null;
    public void reverseTraversal(TreeNode root) {
        if (root.right != null) {
            reverseTraversal(root.right);
        }
        if (next != null) {
            root.val += next.val;
        }
        next = root;
        if (root.left != null) {
            reverseTraversal(root.left);
        }
    }
}
