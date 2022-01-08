package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 08/01/2022 15:25
 */
public class LeetCode0617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        return recursiveMerge(root1, root2);
    }

    public TreeNode recursiveMerge(TreeNode node1, TreeNode node2) {
        if (node1 == null) {
            return node2;
        } else if (node2 == null) {
            return node1;
        } else {
            node1.val += node2.val;
            node1.left = recursiveMerge(node1.left, node2.left);
            node1.right = recursiveMerge(node1.right, node2.right);
            return node1;
        }
    }
}
