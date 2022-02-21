package ink.vor.binarytree;

/**
 * @author muquanrui
 * @date 21/02/2022 20:56
 */
public class LeetCode0101 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == rightNode) {
            return true;
        }
        if (leftNode != null && rightNode != null && leftNode.val == rightNode.val) {
            return isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left);
        }
        return false;
    }
}
