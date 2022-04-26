package ink.vor.sword2offer;

/**
 * @author muquanrui
 * @date 2022/4/26 14:27
 */
public class Offer54 {
    public int kthLargest(TreeNode root, int k) {
        traversal(root, k);
        return res;
    }

    private int cur = 0;
    private int res = 0;
    private boolean traversal(TreeNode root, int k) {
        if (root.right != null && traversal(root.right, k)) {
            return true;
        }
        cur++;
        if (cur == k) {
            res = root.val;
        }
        if (root.left != null && traversal(root.left, k)) {
            return true;
        }
        return false;
    }
}
