package ink.vor.top100liked;

/**
 * @author muquanrui
 * @date 14/12/2021 19:57
 */
public class LeetCode0114 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        flatten(root);
    }

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode newRoot = new TreeNode();
        TreeNode temp = newRoot;
        treeToList(temp, root);
        root.right = newRoot.right.right;
        root.left = null;
    }

    public static TreeNode treeToList(TreeNode newNode, TreeNode node) {
        newNode.right = new TreeNode(node.val);

        if (node.left != null) {
            newNode = treeToList(newNode.right, node.left);
        }
        if (node.right != null) {
            newNode = treeToList(newNode.right, node.right);
        }

        return newNode;
    }
}
