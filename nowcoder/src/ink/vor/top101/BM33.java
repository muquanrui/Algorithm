package ink.vor.top101;

/**
 * @author muquanrui
 * @date 06/04/2022 03:41
 */
public class BM33 {
    public TreeNode Mirror (TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }
        TreeNode temp = pRoot.left;
        pRoot.left = Mirror(pRoot.right);
        pRoot.right = Mirror(temp);
        return pRoot;
    }
}
