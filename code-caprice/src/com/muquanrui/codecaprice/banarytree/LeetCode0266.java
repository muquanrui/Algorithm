package com.muquanrui.codecaprice.banarytree;

/**
 * @author muquanrui
 * @date 2022/5/3 18:33
 */
public class LeetCode0266 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
