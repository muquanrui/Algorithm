package ink.vor.dynamicprogramming;

/**
 * @author muquanrui
 * @date 20/03/2022 17:57
 */
public class LeetCode0337 {
    public int rob(TreeNode root) {
        int[] res = recursiveRob(root);
        return Math.max(res[0], res[1]);
    }

    public int[] recursiveRob(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = recursiveRob(node.left);
        int[] right = recursiveRob(node.right);
        node.val = Math.max(node.val + left[1] + right[1], left[0] + right[0]);
        return new int[]{node.val, left[0] + right[0]};
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
