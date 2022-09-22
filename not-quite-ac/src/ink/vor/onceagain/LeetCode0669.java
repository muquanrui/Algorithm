package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/7/1 16:37
 */

/**
 * https://leetcode.cn/problems/trim-a-binary-search-tree/
 * 二叉搜索树
 */
public class LeetCode0669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
