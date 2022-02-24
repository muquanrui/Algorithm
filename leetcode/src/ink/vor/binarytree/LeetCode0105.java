package ink.vor.binarytree;

import java.util.Arrays;

/**
 * @author muquanrui
 * @date 24/02/2022 21:37
 */
public class LeetCode0105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        divideAndConquer(root, preorder, 0, inorder, 0, inorder.length);
        return root;
    }

    private void divideAndConquer(TreeNode node, int[] preorder, int iPre, int[] inorder, int lIn, int rIn) {
        int iIn = searchInorder(inorder, node.val, lIn, rIn);
        if (iIn > lIn) {
            node.left = new TreeNode(preorder[iPre + 1]);
            divideAndConquer(node.left, preorder, iPre + 1, inorder, lIn, iIn);
        }
        if (iIn < rIn - 1) {
            node.right = new TreeNode(preorder[iPre + iIn - lIn + 1]);
            divideAndConquer(node.right, preorder, iPre + iIn - lIn + 1, inorder, iIn + 1, rIn);
        }
    }

    private int searchInorder(int[] inorder, int target, int l, int r) {
        for (int i = l; i < r; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
