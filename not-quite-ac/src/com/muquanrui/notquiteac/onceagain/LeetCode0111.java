package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/12 14:56
 */

/**
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 * 二叉树
 */
public class LeetCode0111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 叶子节点
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 非叶子节点但是只有一边有子树
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        // 非叶子节点两边都有子树
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}