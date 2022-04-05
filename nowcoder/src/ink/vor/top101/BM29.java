package ink.vor.top101;

/**
 * @author muquanrui
 * @date 05/04/2022 18:23
 */
public class BM29 {
    public boolean hasPathSum (TreeNode root, int sum) {
        return dfs(root, 0, sum);
    }

    public boolean dfs(TreeNode root, int sum, int target) {
        if (root == null) {
            return false;
        }
        sum += root.val;
        if (root.left == null && root.right == null) {
            return sum == target;
        }
        return dfs(root.left, sum, target) || dfs(root.right, sum, target);
    }
}
