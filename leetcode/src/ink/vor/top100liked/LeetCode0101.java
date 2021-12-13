package ink.vor.top100liked;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 13/12/2021 15:24
 */
public class LeetCode0101 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        return recursiveCheck(root.left, root.right);
    }

    public static boolean recursiveCheck(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode != null && rightNode != null && leftNode.val == rightNode.val) {
            return recursiveCheck(leftNode.left, rightNode.right) && recursiveCheck(leftNode.right, rightNode.left);
        }
        return false;
    }

}
