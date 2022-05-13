package ink.vor.dynamicprogramming;

import ink.vor.banarytree.TreeNode;

/**
 * @author muquanrui
 * @date 2022/5/13 17:59
 */
public class LeetCode0337 {
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int val1 = left[0] + right[0];
        int val2 = left[1] + right[1] + root.val;
        root.val = Math.max(val1, val2);
        return new int[]{root.val, val1};
    }
}
