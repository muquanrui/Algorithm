package ink.vor.top100liked;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author muquanrui
 * @date 13/12/2021 16:33
 */
public class LeetCode0102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        List<List<Integer>> resList = levelOrder(root);
        System.out.println(Arrays.toString(resList.toArray()));
    }

    public static List<List<Integer>> resList;
    public static List<List<Integer>> levelOrder(TreeNode root) {
        resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        recursiveLevel(root, 1);
        return resList;
    }

    public static void recursiveLevel(TreeNode node, int level) {
        if (level > resList.size()) {
            List<Integer> tempList = new ArrayList<>();
            tempList.add(node.val);
            resList.add(tempList);
        } else {
            resList.get(level - 1).add(node.val);
        }
        if (node.left != null) {
            recursiveLevel(node.left, level + 1);
        }
        if (node.right != null) {
            recursiveLevel(node.right, level + 1);
        }
    }
}
