package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/26 14:27
 */
public class Offer55_1 {
    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        depth++;
        return Math.max(dfs(root.left, depth), dfs(root.right, depth));
    }
}
