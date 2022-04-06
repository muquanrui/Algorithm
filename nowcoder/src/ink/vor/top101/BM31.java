package ink.vor.top101;

/**
 * @author muquanrui
 * @date 06/04/2022 03:40
 */
public class BM31 {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    boolean isSymmetrical(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null && rightRoot == null) {
            return true;
        }
        if (leftRoot != null && rightRoot != null && leftRoot.val == rightRoot.val) {
            return isSymmetrical(leftRoot.left, rightRoot.right)
                    && isSymmetrical(leftRoot.right, rightRoot.left);
        }
        return false;
    }
}
