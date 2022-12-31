package com.muquanrui.notquiteac.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/28 13:15
 */

/**
 * https://leetcode.cn/problems/delete-node-in-a-bst/
 * 二叉搜索树
 */
public class LeetCode0450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode right = root.right;
            TreeNode left = root.left;
            TreeNode cur = left;
            while (cur.right != null) {
                cur = cur.right;
            }
            cur.right = right.left;
            right.left = left;
            return right;
        }
        return root;
    }
}
