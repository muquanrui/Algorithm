package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/6/20 14:28
 */
public class LeetCode0222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rigthDepth = getDepth(root.right);
        if (leftDepth == rigthDepth) {
            return (1 << leftDepth) + countNodes(root.right);
        } else {
            return (1 << rigthDepth) + countNodes(root.left);
        }
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getDepth(root.left) + 1;
    }
}
