package ink.vor.binarytree;

/**
 * @author muquanrui
 * @date 25/02/2022 21:28
 */
public class LeetCode0617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        int root1Val = root1 == null ? 0 : root1.val;
        int root2Val = root2 == null ? 0 : root2.val;
        TreeNode newRoot = new TreeNode(root1Val + root2Val);
        newRoot.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        newRoot.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return newRoot;
    }
}
