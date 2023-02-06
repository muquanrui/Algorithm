package com.muquanrui.dailyleetcoding;

/**
 * @author muquanrui
 * @date 2023/2/6 12:01
 */

public class LeetCode2331 {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 0 ? false : true;
        }
        return root.val == 2 ? evaluateTree(root.left) || evaluateTree(root.right) :
                evaluateTree(root.left) && evaluateTree(root.right);
    }
}
