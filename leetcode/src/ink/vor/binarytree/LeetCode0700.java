package ink.vor.binarytree;

/**
 * @author muquanrui
 * @date 25/02/2022 21:41
 */
public class LeetCode0700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        } else if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
