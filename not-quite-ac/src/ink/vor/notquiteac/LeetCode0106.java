package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/6/11 22:44
 */
public class LeetCode0106 {
    // public TreeNode buildTree(int[] inorder, int[] postorder) {
    //     return buildTree(postorder, postorder.length - 1, inorder, 0, inorder.length - 1);
    // }

    // private TreeNode buildTree(int[] postorder, int postIndex, int[] inorder, int left, int right) {
    //     if (left > right) {
    //         return null;
    //     }
    //     TreeNode root = new TreeNode(postorder[postIndex]);
    //     int inIndex = findInorderIndex(inorder, left, right, root.val);
    //     root.right = buildTree(postorder, postIndex - 1, inorder, inIndex + 1, right);
    //     root.left = buildTree(postorder, postIndex - (right - inIndex) - 1, inorder, left, inIndex - 1);
    //     return root;
    // }

    // private int findInorderIndex(int[] inorder, int left, int right, int target) {
    //     for (int i = left; i <= right; i++) {
    //         if (inorder[i] == target) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        in = inorder.length - 1;
        post = postorder.length - 1;
        return buildTree(inorder, postorder, Integer.MAX_VALUE);
    }
    int in;
    int post;
    private TreeNode buildTree(int[] inorder, int[] postorder, int max) {
        if (in == inorder.length || post == -1 || max == inorder[in]) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[post]);
        post--;
        root.right = buildTree(inorder, postorder, root.val);
        in--;
        root.left = buildTree(inorder, postorder, max);
        return root;
    }
}
