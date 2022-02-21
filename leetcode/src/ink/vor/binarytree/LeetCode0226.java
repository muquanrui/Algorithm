package ink.vor.binarytree;

/**
 * @author muquanrui
 * @date 21/02/2022 20:49
 */
public class LeetCode0226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        recursiveInvert(root);
        return root;
    }

    private void recursiveInvert(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        if (node.left != null) {
            recursiveInvert(node.left);
        }
        if (node.right != null) {
            recursiveInvert(node.right);
        }
    }
}
