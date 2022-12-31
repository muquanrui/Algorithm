package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/11 21:17
 */

/**
 * https://leetcode.cn/problems/validate-binary-search-tree/
 * 二叉搜索树
 */
public class LeetCode0098 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // 判断当前节点值是否在开区间内
    // 向左子树走更新最大值
    // 向右子树走更新最小值
    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
