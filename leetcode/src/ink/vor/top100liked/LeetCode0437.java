package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 06/01/2022 20:48
 */
public class LeetCode0437 {
    public int path;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        path = 0;
        traversal(root, targetSum);
        return path;
    }

    public void traversal(TreeNode root, int target) {
        dfs(root, target, 0);

        if (root.left != null) {
            traversal(root.left, target);
        }
        if (root.right != null) {
            traversal(root.right, target);
        }
    }

    public void dfs(TreeNode node, int target, int sum) {
        sum += node.val;
        if (sum == target) {
            path++;
        }
        if (node.left != null) {
            dfs(node.left, target, sum);
        }
        if (node.right != null) {
            dfs(node.right, target, sum);
        }
    }
}
