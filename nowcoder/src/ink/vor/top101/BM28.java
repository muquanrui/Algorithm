package ink.vor.top101;

/**
 * @author muquanrui
 * @date 05/04/2022 18:20
 */
public class BM28 {
    public int maxDepth (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
