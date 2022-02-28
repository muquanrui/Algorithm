package ink.vor.binarytree;

/**
 * @author muquanrui
 * @date 28/02/2022 22:36
 */
public class LeetCode0538 {
    TreeNode pre = null;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        if (pre != null) {
            root.val += pre.val;
        }
        pre = root;
        convertBST(root.left);
        return root;
    }
}
