package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 14/12/2021 14:04
 */
public class LeetCode0104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        System.out.println(maxDepth(root));
    }
    public static int maxDepth(TreeNode root) {
        depth = 0;
        if (root != null) {
            recursiveDepth(root, 0);
        }
        return depth;
    }

    public static int depth;
    public static void recursiveDepth(TreeNode node, int level) {
        level++;
        depth = Math.max(level, depth);
        if (node.left != null) {
            recursiveDepth(node.left, level);
        }
        if (node.right != null) {
            recursiveDepth(node.right, level);
        }
    }
}
