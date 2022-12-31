package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/12 15:19
 */

/**
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 * 二叉树
 */
public class LeetCode0114 {
    // 记录前一个节点
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // 设置前一个节点的left为空，right为当前节点
        if (pre != null) {
            pre.left = null;
            pre.right = root;
        }
        // pre更新为当前节点
        pre = root;
        // 当前节点的right在向左子树递归的时候会改变，需要暂存
        TreeNode right = root.right;
        // 向左、右子树分别递归
        flatten(root.left);
        flatten(right);
    }
}
