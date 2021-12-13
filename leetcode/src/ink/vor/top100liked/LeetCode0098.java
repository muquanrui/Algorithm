package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 13/12/2021 14:04
 */
public class LeetCode0098 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return recursiveCheck(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean recursiveCheck(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max){
            return false;
        }
        return recursiveCheck(node.left, min, node.val) && recursiveCheck(node.right, node.val, max);
    }

}
