package ink.vor.onceagain;


/**
 * @author muquanrui
 * @date 2022/6/20 14:28
 */

/**
 * https://leetcode.cn/problems/count-complete-tree-nodes/
 * 完全二叉树
 */
public class LeetCode0222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) + countNodes(root.right);
        } else {
            return (1 << rightDepth) + countNodes(root.left);
        }
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
}
