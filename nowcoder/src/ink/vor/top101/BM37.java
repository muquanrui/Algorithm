package ink.vor.top101;

/**
 * @author muquanrui
 * @date 07/04/2022 01:14
 */
public class BM37 {
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        // write code here
        if (root.val == p || root.val == q) {
            return root.val;
        } else if (root.val > p && root.val > q) {
            return lowestCommonAncestor(root.left, p ,q);
        } else if (root.val < p && root.val < q) {
            return lowestCommonAncestor(root.right, p ,q);
        } else {
            return root.val;
        }
    }
}
