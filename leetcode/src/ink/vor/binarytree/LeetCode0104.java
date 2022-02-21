package ink.vor.binarytree;

/**
 * @author muquanrui
 * @date 21/02/2022 21:13
 */
public class LeetCode0104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return maxDepth(root, 1);
    }

    private int maxDepth(TreeNode node, int depth) {
        int res1 = depth;
        int res2 = depth;
        if (node.left != null) {
            res1 = maxDepth(node.left, depth + 1);
        }
        if (node.right != null) {
            res2 = maxDepth(node.right, depth + 1);
        }
        return Math.max(res1, res2);
    }
}
