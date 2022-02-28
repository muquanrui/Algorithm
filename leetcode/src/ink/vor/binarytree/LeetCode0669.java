package ink.vor.binarytree;

import java.util.Stack;

/**
 * @author muquanrui
 * @date 28/02/2022 22:22
 */
public class LeetCode0669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        if (root.val < low || root.val > high) {
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                TreeNode pre = root;
                TreeNode maxLeft = root.left;
                while (maxLeft.right != null) {
                    pre = maxLeft;
                    maxLeft = maxLeft.right;
                }
                if (pre != root) {
                    pre.right = null;
                } else {
                    pre.left = null;
                }
                maxLeft.right = root.right;
                TreeNode minOfMaxLeft = maxLeft;
                while (minOfMaxLeft.left != null) {
                    minOfMaxLeft = minOfMaxLeft.left;
                }
                minOfMaxLeft.left = root.left;
                root = maxLeft;
            }
        }
        return root;
    }
}
