package ink.vor.top101;

/**
 * @author muquanrui
 * @date 07/04/2022 01:14
 */
public class BM36 {
    public boolean IsBalanced_Solution(TreeNode root) {
        int height = dfs(root);
        return height == -1 ? false : true;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);

        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) <= 1) {
            return Math.max(leftHeight, rightHeight) + 1;
        } else {
            return -1;
        }
    }
}
