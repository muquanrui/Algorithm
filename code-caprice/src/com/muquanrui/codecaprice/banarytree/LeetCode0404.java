package com.muquanrui.codecaprice.banarytree;

/**
 * @author muquanrui
 * @date 2022/5/5 22:26
 */
public class LeetCode0404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
