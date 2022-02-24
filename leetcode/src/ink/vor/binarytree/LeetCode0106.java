package ink.vor.binarytree;

/**
 * @author muquanrui
 * @date 24/02/2022 23:23
 */
public class LeetCode0106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        divideAndConquer(root, postorder, postorder.length - 1, inorder, 0, inorder.length -1);
        return root;
    }

    private void divideAndConquer(TreeNode node, int[] postorder, int iPost, int[] inorder, int lIn, int rIn) {
        int iIn = searchInorder(inorder, node.val, lIn, rIn);
        if (iIn > lIn) {
            node.left = new TreeNode(postorder[iPost - (rIn - iIn) - 1]);
            divideAndConquer(node.left, postorder, iPost - (rIn - iIn) - 1, inorder, lIn, iIn - 1);
        }
        if (iIn < rIn) {
            node.right = new TreeNode(postorder[iPost - 1]);
            divideAndConquer(node.right, postorder, iPost - 1, inorder, iIn + 1, rIn);
        }
    }

    private int searchInorder(int[] inorder, int target, int l, int r) {
        for (int i = l; i <= r; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
