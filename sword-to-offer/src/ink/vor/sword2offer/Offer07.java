package ink.vor.sword2offer;
/**
 * @author muquanrui
 * @date 2022/4/21 14:50
 */
public class Offer07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursiveBuild(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode recursiveBuild(int[] preorder, int[] inorder, int indexPre, int startIn, int endIn) {
        if (startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = preorder[indexPre];
        int indexIn = findRoot(inorder, startIn, endIn, preorder[indexPre]);
        root.left = recursiveBuild(preorder, inorder, indexPre + 1, startIn, indexIn - 1);
        root.right = recursiveBuild(preorder, inorder, indexPre + indexIn - startIn + 1, indexIn + 1, endIn);
        return root;
    }

    private int findRoot(int[] inorder, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
