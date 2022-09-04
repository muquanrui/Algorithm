package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/11 21:01
 */

/**
 * https://leetcode.cn/problems/balanced-binary-tree/
 * 平衡二叉树
 */
public class LeetCode0110 {
    public boolean isBalanced(TreeNode root) {
        return getLength(root) != Integer.MAX_VALUE;
    }

    // 递归获取当前节点为root的树高度
    private int getLength(TreeNode root) {
        // 获取左子树高度
        int leftLength = getLength(root.left);
        // 左子树不平衡直接返回特殊值
        if (leftLength == Integer.MAX_VALUE) {
            return leftLength;
        }
        // 获取右子树高度
        int rightLength = getLength(root.right);
        // 平衡则返回高度，不平衡返回特殊值
        return Math.abs(rightLength - leftLength) > 1 ? Integer.MAX_VALUE : Math.max(leftLength, rightLength) + 1;
    }
}
