package ink.vor.top100liked;

import java.util.ArrayList;
import java.util.List;

/**
 * @author muquanrui
 * @date 30/12/2021 11:25
 */
public class LeetCode0236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ancestors = new ArrayList<>();
        recursiveTraversal(root, p, q);
        TreeNode nextSearch;
        nextSearch = ancestors.get(ancestors.size() - 1) == p ? q : p;
        for (int i = ancestors.size() - 1; i >= 0; i--) {
            TreeNode entrance;
            if (i < ancestors.size() - 1) {
                entrance = ancestors.get(i).left == ancestors.get(i + 1) ? ancestors.get(i).right : ancestors.get(i).left;
            } else {
                entrance = ancestors.get(i);
            }
            if (recursiveTraversal(entrance, nextSearch)) {
                return ancestors.get(i);
            }
        }
        return root;
    }

    public List<TreeNode> ancestors;
    public boolean recursiveTraversal(TreeNode node, TreeNode p, TreeNode q) {
        ancestors.add(node);
        if (node == p || node == q) {
            return true;
        }
        if (node.left != null && recursiveTraversal(node.left, p, q)) {
            return true;
        }
        if (node.right != null && recursiveTraversal(node.right, p, q)) {
            return true;
        }
        ancestors.remove(node);
        return false;
    }

    public boolean recursiveTraversal(TreeNode node, TreeNode target) {
        if (node == null) {
            return false;
        }
        if (node == target) {
            return true;
        }
        if (node.left != null && recursiveTraversal(node.left, target)) {
            return true;
        }
        if (node.right != null && recursiveTraversal(node.right, target)) {
            return true;
        }
        return false;
    }
}
