package ink.vor.notquiteac;

/**
 * @author muquanrui
 * @date 2022/6/11 22:44
 */
public class LeetCode0105 {
    /*
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
    */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, Integer.MAX_VALUE);
    }
    int iPre = 0;
    int iIn = 0;
    private TreeNode buildTree(int[] preorder, int[] inorder, int cur) {
        if (iPre == preorder.length || iIn == inorder.length || cur == inorder[iIn]) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[iPre]);
        iPre++;
        root.left = buildTree(preorder, inorder, root.val);
        iIn++;
        root.right = buildTree(preorder, inorder, cur);
        return root;
    }
}
