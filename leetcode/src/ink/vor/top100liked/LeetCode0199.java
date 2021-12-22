package ink.vor.top100liked;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 22/12/2021 17:13
 */
public class LeetCode0199 {
    public List<List<Integer>> levelTraversal;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        levelTraversal = new ArrayList<>();
        recursiveTraversal(root, 1);
        for (List<Integer> list: levelTraversal) {
            resList.add(list.get(list.size() - 1));
        }
        return resList;
    }

    public void recursiveTraversal(TreeNode node, int level) {
        if (level > levelTraversal.size()) {
            List<Integer> temp = new ArrayList<>();
            temp.add(node.val);
            levelTraversal.add(temp);
        } else {
            levelTraversal.get(level - 1).add(node.val);
        }

        if (node.left != null) {
            recursiveTraversal(node.left, level + 1);
        }
        if (node.right != null) {
            recursiveTraversal(node.right, level + 1);
        }
    }
}
