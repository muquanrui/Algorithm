package ink.vor.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author muquanrui
 * @date 26/02/2022 20:42
 */
public class LeetCode0501 {
    List<Integer> list = new ArrayList<>();
    TreeNode pre = null;
    int maxOccur = 0;
    int count = 1;
    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void inorder(TreeNode root) {
        if (root.left != null) {
            inorder(root.left);
        }
        if (pre != null) {
            if (pre.val == root.val) {
                count++;
            } else {
                count = 1;
            }
        }
        if (count > maxOccur) {
            maxOccur = count;
            list.clear();
            list.add(root.val);
        } else if (count == maxOccur) {
            list.add(root.val);
        }
        pre = root;
        if (root.right != null) {
            inorder(root.right);
        }
    }
}
