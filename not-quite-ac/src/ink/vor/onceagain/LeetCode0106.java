package ink.vor.onceagain;

/**
 * @author muquanrui
 * @date 2022/6/11 22:44
 */

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 数组构造二叉树，类似105
 */
public class LeetCode0106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        iIn = inorder.length - 1;
        iPost = postorder.length - 1;
        return build(inorder, postorder, Integer.MAX_VALUE);
    }
    int iIn;
    int iPost;
    private TreeNode build(int[] inorder, int[] postorder, int rootVal) {
        if (iIn < 0 || iPost < 0 || inorder[iIn] == rootVal) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[iPost--]);
        root.right = build(inorder, postorder, root.val);
        iIn--;
        root.left = build(inorder, postorder, rootVal);
        return root;
    }
}