package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 29/12/2021 16:29
 */
public class LeetCode0230 {
    public int index;
    public int res;
    public int kthSmallest(TreeNode root, int k) {
        index = 0;
        res = -1;
        inOrder(root, k);
        return res;
    }

    public boolean inOrder(TreeNode node, int k) {
        if (node.left != null) {
            if (inOrder(node.left, k)) {
                return true;
            }
        }
        index += 1;
        if (index == k) {
            res = node.val;
            return true;
        }

        if (node.right != null) {
            if (inOrder(node.right, k)) {
                return true;
            }
        }
        return false;
    }
}
