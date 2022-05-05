package ink.vor.banarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/5/4 22:06
 */
public class LeetCode0257 {
    List<String> resList = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return resList;
        }
        searchPath(root);
        return resList;
    }

    private void searchPath(TreeNode root) {
        sb.append(root.val);
        int intLength = String.valueOf(root.val).length();
        if (root.left == null && root.right == null) {
            resList.add(sb.toString());
            sb.delete(sb.length() - intLength, sb.length());
            return;
        }
        sb.append("->");
        if (root.left != null) {
            searchPath(root.left);
        }
        if (root.right != null) {
            searchPath(root.right);
        }
        sb.delete(sb.length() - intLength - 2, sb.length());
    }
}
