package ink.vor.top101;

/**
 * @author muquanrui
 * @date 06/04/2022 03:41
 */
public class BM34 {
    public boolean isValidBST (TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST (TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val < max && root.val > min) {
            return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
        }
        return false;
    }
}
