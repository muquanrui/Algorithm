package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/11 22:44
 */

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 数组构造二叉树
 */
public class LeetCode0105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MAX_VALUE);
    }
    // 记录pre数组的下标
    int iPre = 0;
    // 记录in数组的下标
    int iIn = 0;
    private TreeNode build(int[] preorder, int[] inorder, int rootVal) {
        // 递归退出条件：pre或in走到最后；往子树走到尽头即pre当前值和in当前值相等
        if (iPre == preorder.length || iIn == inorder.length || inorder[iIn] == rootVal) {
            return null;
        }
        // 递归左子树，更新root节点的值为当前节点值
        TreeNode root = new TreeNode(preorder[iPre++]);
        root.left = build(preorder, inorder, root.val);
        // 左子树走完，in数组下标+1
        iIn++;
        // 递归右子树，不更新root节点值
        root.right = build(preorder, inorder, rootVal);
        return root;
    }
}
