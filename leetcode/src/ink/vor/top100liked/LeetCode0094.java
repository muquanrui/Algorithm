package ink.vor.top100liked;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author muquanrui
 * @date 13/12/2021 10:17
 */
public class LeetCode0094 {
    public static void main(String[] args) {
        Object[] nums = {1,null,2,3};
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        inorderTraversal(root);
        System.out.println(Arrays.toString(resList.toArray()));
    }

    public static List<Integer> resList;
    public static List<Integer> inorderTraversal(TreeNode root) {
        resList = new ArrayList<>();
        inorder(root);
        return resList;
    }

    public static void inorder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.left != null) {
            inorder(treeNode.left);
        }
        resList.add(treeNode.val);
        if (treeNode.right != null) {
            inorder(treeNode.right);
        }
    }
}

