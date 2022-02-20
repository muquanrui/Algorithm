package ink.vor.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author muquanrui
 * @date 20/02/2022 22:18
 */
public class LeetCode0102 {
    List<List<Integer>> resList;
    public List<List<Integer>> levelOrder(TreeNode root) {
        resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        recursiveTraversal(root, 0);
        return resList;
    }
    public void recursiveTraversal(TreeNode node, int level) {
        if (level < resList.size()) {
            resList.get(level).add(node.val);
        } else {
            resList.add(new ArrayList<>(Arrays.asList(node.val)));
        }
        if (node.left != null) {
            recursiveTraversal(node.left, level + 1);
        }
        if (node.right != null) {
            recursiveTraversal(node.right, level + 1);
        }
    }
}
