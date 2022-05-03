package ink.vor.banarytree;

/**
 * @author muquanrui
 * @date 2022/5/3 18:40
 */
public class LeetCode0104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
