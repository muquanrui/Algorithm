package ink.vor.top101;

/**
 * @author muquanrui
 * @date 05/04/2022 19:13
 */
public class BM30 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        return inorder(pRootOfTree, null);
    }

    public TreeNode inorder(TreeNode root, TreeNode next) {
        if (root.right != null) {
            next = inorder(root.right, next);
        }
        root.right = next;
        if (next != null) {
            next.left = root;
        }
        if (root.left != null) {
            return inorder(root.left, root);
        } else {
            return root;
        }
    }
}
