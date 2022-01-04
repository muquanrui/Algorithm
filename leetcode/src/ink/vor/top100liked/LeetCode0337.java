package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 04/01/2022 16:24
 */
public class LeetCode0337 {
    public int rob(TreeNode root) {
        return recursiveRob(root)[2];
    }

    public int[] recursiveRob(TreeNode node) {
        int[] res = new int[3];
        if (node == null) {
            return res;
        }
        if (node.left == null && node.right == null) {
            res[0] = 0;
            res[1] = node.val;
            res[2] = node.val;
            return res;
        }
        int[] resLeft = recursiveRob(node.left);
        int[] resRight = recursiveRob(node.right);

        res[0] = resLeft[2] + resRight[2];
        res[1] = node.val + resLeft[0] + resRight[0];
        res[2] = res[0] > res[1] ? res[0] : res[1];
        return res;
    }
}
