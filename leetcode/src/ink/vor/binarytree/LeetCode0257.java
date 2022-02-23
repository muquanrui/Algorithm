package ink.vor.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 23/02/2022 19:40
 */
public class LeetCode0257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resList = new ArrayList<>();
        binaryTreePaths(root, new StringBuilder(), resList);
        return resList;
    }

    private void binaryTreePaths(TreeNode node, StringBuilder sb, List<String> resList) {
        sb = new StringBuilder(sb);
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            resList.add(sb.toString());
            return;
        }
        sb.append("->");
        if (node.left != null) {
            binaryTreePaths(node.left, sb, resList);
        }
        if (node.right != null) {
            binaryTreePaths(node.right, sb, resList);
        }
    }
}
