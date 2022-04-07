package ink.vor.top101;

/**
 * @author muquanrui
 * @date 07/04/2022 01:15
 */
public class BM38 {
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        if (root == null) {
            return -1;
        }
        if (root.val == o1 || root.val == o2) {
            return root.val;
        }
        int left = lowestCommonAncestor(root.left, o1, o2);
        int right = lowestCommonAncestor(root.right, o1, o2);
        if (left != -1 && right != -1) {
            return root.val;
        } else if (left == -1 && right == -1) {
            return -1;
        } else {
            return left == -1 ? right : left;
        }
    }
}
