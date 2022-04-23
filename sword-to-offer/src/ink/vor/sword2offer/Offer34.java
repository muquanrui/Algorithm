package ink.vor.sword2offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author muquanrui
 * @date 2022/4/23 17:52
 */
public class Offer34 {
    List<List<Integer>> resList = new LinkedList<>();
    List<Integer> list = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return resList;
        }
        backtracking(root, 0, target);
        return resList;
    }

    private void backtracking(TreeNode root, int sum, int target) {
        if (root.left == null && root.right == null && sum + root.val == target) {
            list.add(root.val);
            resList.add(new LinkedList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(root.val);
        sum += root.val;
        if (root.left != null) {
            backtracking(root.left, sum, target);
        }
        if (root.right != null) {
            backtracking(root.right, sum, target);
        }
        list.remove(list.size() - 1);
    }
}
